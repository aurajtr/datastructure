// Stack (LIFO) berbasis linked list: riwayat transaksi
public class Stack {
    private Node top;
    private int size;

    public boolean isEmpty() { return top == null; }

    // Simpan transaksi di paling atas
    public void push(String kode, String nama, double total) {
        Node baru = new Node(kode, nama, total);
        baru.next = top;
        top = baru;
        size++;
    }

    // Tampilkan dari transaksi terbaru ke terlama
    public void display() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat transaksi (terbaru di atas):");
        Node bantu = top;
        int no = 1;
        while (bantu != null) {
            System.out.println(no++ + ". " + bantu.kode + " | " + bantu.nama + " | Rp" + (long) bantu.total);
            bantu = bantu.next;
        }
        System.out.println("Total transaksi: " + size);
    }
}
