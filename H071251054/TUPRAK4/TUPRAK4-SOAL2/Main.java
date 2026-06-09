import java.util.Scanner;

public class Main {
    static Product[] stok = new Product[100];
    static int jumlah = 0;

    static void tampilkanMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Keluar");
    }

    static void tambahProduk(Scanner sc) {
        System.out.print("Masukkan brand: ");
        String brand = sc.nextLine();

        System.out.print("Masukkan nomor seri: ");
        int series = sc.nextInt();

        System.out.print("Masukkan harga: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.println("1. Smartphone\n2. Laptop\n3. Camera");
        System.out.print("Pilih tipe: ");
        int tipe = sc.nextInt();
        sc.nextLine();

        if (tipe == 1) {
            System.out.print("Screen size: ");
            double size = sc.nextDouble();
            System.out.print("Storage: ");
            int storage = sc.nextInt();
            sc.nextLine();
            stok[jumlah++] = new Smartphone(brand, series, price, size, storage);

        } else if (tipe == 2) {
            System.out.print("RAM: ");
            int ram = sc.nextInt();
            sc.nextLine();
            System.out.print("Processor: ");
            String proc = sc.nextLine();
            stok[jumlah++] = new Laptop(brand, series, price, ram, proc);

        } else if (tipe == 3) {
            System.out.print("Resolution: ");
            int res = sc.nextInt();
            sc.nextLine();
            System.out.print("Lens: ");
            String lens = sc.nextLine();
            stok[jumlah++] = new Camera(brand, series, price, res, lens);
        }
    }

    static void tampilkanSemuaProduk() {
        for (int i = 0; i < jumlah; i++) {
            stok[i].displayInfo();
            System.out.println();
        }
    }

    static void beliProduk(Scanner sc) {
        System.out.print("Masukkan nomor seri: ");
        int cari = sc.nextInt();

        boolean ketemu = false;

        for (int i = 0; i < jumlah; i++) {
            if (stok[i].seriesNumber == cari) {
                System.out.println("Produk ditemukan:");
                stok[i].displayInfo();
                ketemu = true;
                break;
            }
        }

        if (!ketemu) {
            System.out.println("Produk tidak ditemukan!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            tampilkanMenu();
            System.out.print(">>> Pilih menu (1-4): ");

            try {
                int pilihan = Integer.parseInt(sc.nextLine().trim());

                if (pilihan == 1) {
                    tambahProduk(sc);
                } else if (pilihan == 2) {
                    tampilkanSemuaProduk();
                } else if (pilihan == 3) {
                    beliProduk(sc);
                } else if (pilihan == 4) {
                    System.out.println("Terima kasih!");
                    break;
                } else {
                    System.out.println("Pilihan tidak valid! Masukkan angka 1-4.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka, bukan huruf atau simbol.");
            }
        }
    }
}