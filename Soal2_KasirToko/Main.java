import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            while (!sc.hasNextInt()) {
                System.out.print("Input harus angka. Pilih menu: ");
                sc.next();
            }
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    if (antrian.isFull()) {
                        System.out.println("Antrian penuh! Maksimal " + Queue.MAKS + " pelanggan.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Antrian: ");
                    String kode = sc.nextLine().trim();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = sc.nextLine().trim();
                    System.out.print("Masukkan Total Belanja: ");
                    while (!sc.hasNextDouble()) {
                        System.out.print("Total belanja harus angka. Masukkan lagi: ");
                        sc.next();
                    }
                    double total = sc.nextDouble();
                    sc.nextLine();
                    if (antrian.enqueue(kode, nama, total)) {
                        System.out.println("Data pelanggan ditambahkan ke antrian!");
                    }
                    break;
                case 2:
                    Node dilayani = antrian.dequeue(); // dequeue dari antrian
                    if (dilayani == null) {
                        System.out.println("Antrian kosong, tidak ada pelanggan yang dilayani.");
                    } else {
                        System.out.println("Melayani pelanggan " + dilayani.kode + " (" + dilayani.nama + ")");
                        riwayat.push(dilayani.kode, dilayani.nama, dilayani.total); // push ke stack
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;
                case 3:
                    antrian.display();
                    break;
                case 4:
                    riwayat.display();
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
