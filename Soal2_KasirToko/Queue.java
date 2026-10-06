// Queue (FIFO) berbasis linked list: antrian pelanggan
public class Queue {
    private Node front, rear;
    private int size;
    public static final int MAKS = 5; // validasi jumlah data <= 5

    public boolean isEmpty() { return front == null; }
    public boolean isFull()  { return size >= MAKS; }
    public int getSize()     { return size; }

    // Masukkan pelanggan di belakang antrian
    public boolean enqueue(String kode, String nama, double total) {
        if (isFull()) {
            System.out.println("Antrian penuh! Maksimal " + MAKS + " pelanggan.");
            return false;
        }
        Node baru = new Node(kode, nama, total);
        if (isEmpty()) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        size++;
        return true;
    }

    // Ambil pelanggan dari depan antrian
    public Node dequeue() {
        if (isEmpty()) return null;
        Node keluar = front;
        front = front.next;
        if (front == null) rear = null;
        size--;
        keluar.next = null;
        return keluar;
    }

    // Tampilkan antrian dari depan ke belakang
    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian saat ini:");
        Node bantu = front;
        int no = 1;
        while (bantu != null) {
            System.out.println(no++ + ". " + bantu.kode + " | " + bantu.nama + " | Rp" + (long) bantu.total);
            bantu = bantu.next;
        }
        System.out.println("Jumlah antrian: " + size);
    }
}
