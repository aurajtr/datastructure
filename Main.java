import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        int pilihan;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            // validasi input menu harus angka
            while (!sc.hasNextInt()) {
                System.out.print("Input harus angka. Pilih menu: ");
                sc.next();
            }
            pilihan = sc.nextInt();
            sc.nextLine(); // buang sisa enter

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine().trim();
                    // validasi: kode maksimal 5 karakter
                    if (kode.isEmpty() || kode.length() > 5) {
                        System.out.println("Kode buku harus 1-5 karakter!");
                        break;
                    }
                    if (daftar.kodeSudahAda(kode)) {
                        System.out.println("Kode buku sudah dipakai!");
                        break;
                    }
                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = sc.nextLine();
                    daftar.tambahBuku(kode, judul, penulis);
                    System.out.println("Data berhasil ditambahkan!");
                    break;
                case 2:
                    daftar.hapusBuku();
                    break;
                case 3:
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    daftar.cariBuku(sc.nextLine().trim());
                    break;
                case 4:
                    daftar.tampilkanSemua();
                    break;
                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (pilihan != 5);

        sc.close();
    }
}
