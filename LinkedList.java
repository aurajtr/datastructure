// Single Linked List untuk data buku perpustakaan
public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // Tambah buku di akhir daftar (Push)
    public void tambahBuku(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);
        if (head == null) {
            head = baru; // daftar masih kosong
        } else {
            Node bantu = head;
            while (bantu.next != null) { // cari node terakhir
                bantu = bantu.next;
            }
            bantu.next = baru;
        }
        size++;
    }

    // Hapus buku terakhir (Pop)
    public void hapusBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }
        Node dihapus;
        if (head.next == null) { // hanya satu data
            dihapus = head;
            head = null;
        } else {
            Node bantu = head;
            while (bantu.next.next != null) { // berhenti di node sebelum terakhir
                bantu = bantu.next;
            }
            dihapus = bantu.next;
            bantu.next = null;
        }
        size--;
        System.out.println("Buku terakhir berhasil dihapus: " + dihapus.kodeBuku + " - " + dihapus.judul);
    }

    // Cari buku berdasarkan kode
    public void cariBuku(String kode) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kode)) {
                System.out.println("Buku ditemukan!");
                System.out.println("Kode    : " + bantu.kodeBuku);
                System.out.println("Judul   : " + bantu.judul);
                System.out.println("Penulis : " + bantu.penulis);
                return;
            }
            bantu = bantu.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }

    // Cek apakah kode sudah dipakai
    public boolean kodeSudahAda(String kode) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kode)) return true;
            bantu = bantu.next;
        }
        return false;
    }

    // Tampilkan semua buku sesuai urutan input
    public void tampilkanSemua() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            System.out.println("Total Buku: 0");
            return;
        }
        System.out.println("Daftar Buku:");
        Node bantu = head;
        while (bantu != null) {
            System.out.println("Kode: " + bantu.kodeBuku + " | Judul: " + bantu.judul + " | Penulis: " + bantu.penulis);
            bantu = bantu.next;
        }
        System.out.println("Total Buku: " + size);
        if (size < 5) {
            System.out.println("(Catatan: data minimal 5 buku, saat ini baru " + size + ")");
        }
    }
}
