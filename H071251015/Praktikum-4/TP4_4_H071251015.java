import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mainToko {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> stok = new ArrayList<>();

    public static void main(String[] args) {
        // Data awal (pre-loaded)
        stok.add(new Smartphone("Samsung", 123456, 899.99, 6.5, 256));
        stok.add(new Laptop("Dell", 987654, 1299.99, 16, "Intel Core i7"));
        stok.add(new Camera("Canon", 456789, 699.99, 24, "Telephoto"));

        while (true) {
            tampilkanMenu();
            System.out.print(">>> Pilih menu (1-4): ");
            try {
                int pilihan = sc.nextInt();
                sc.nextLine();

                switch (pilihan) {
                    case 1: tambahProduk(); break;
                    case 2: tampilkanSemuaProduk(); break;
                    case 3: beliProduk(); break;
                    case 4:
                        System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                        return;
                    default:
                        System.out.println("[ERROR] Pilihan tidak valid! Silakan pilih antara 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Input harus berupa angka! Silakan coba lagi.");
                sc.nextLine(); // flush input yang salah
            }
        }
    }

    static void tampilkanMenu() {
        System.out.println("\n========== MENU TOKO ==========");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Keluar");
        System.out.println("================================");
    }

    static void tambahProduk() {
        try {
            System.out.print("Masukkan nama/brand produk: ");
            String brand = sc.nextLine();
            if (brand.trim().isEmpty()) throw new Exception("Nama produk tidak boleh kosong!");

            System.out.print("Masukkan nomor seri: ");
            int seriesNumber = sc.nextInt();

            System.out.print("Masukkan harga: ");
            double price = sc.nextDouble();
            if (price <= 0) throw new Exception("Harga harus lebih dari 0!");
            sc.nextLine();

            System.out.println("Pilih tipe produk:");
            System.out.println("1. Smartphone");
            System.out.println("2. Laptop");
            System.out.println("3. Camera");
            System.out.print("Pilih tipe produk (1-3): ");
            int tipe = sc.nextInt();
            sc.nextLine();

            switch (tipe) {
                case 1:
                    System.out.print("Masukkan ukuran layar (inci): ");
                    double screenSize = sc.nextDouble();
                    System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                    int storage = sc.nextInt();
                    sc.nextLine();
                    stok.add(new Smartphone(brand, seriesNumber, price, screenSize, storage));
                    System.out.println("[OK] Smartphone berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.print("Masukkan ukuran RAM (GB): ");
                    int ram = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Masukkan tipe prosesor: ");
                    String processor = sc.nextLine();
                    stok.add(new Laptop(brand, seriesNumber, price, ram, processor));
                    System.out.println("[OK] Laptop berhasil ditambahkan!");
                    break;
                case 3:
                    System.out.print("Masukkan resolusi kamera (MP): ");
                    int resolution = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Masukkan tipe lensa: ");
                    String lensType = sc.nextLine();
                    stok.add(new Camera(brand, seriesNumber, price, resolution, lensType));
                    System.out.println("[OK] Camera berhasil ditambahkan!");
                    break;
                default:
                    System.out.println("[ERROR] Tipe produk tidak valid!");
            }

        } catch (InputMismatchException e) {
            System.out.println("[ERROR] Input tidak valid! Pastikan memasukkan tipe data yang benar.");
            sc.nextLine(); // flush
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            sc.nextLine();
        }
    }

    static void tampilkanSemuaProduk() {
        try {
            if (stok.isEmpty()) {
                System.out.println("[INFO] Tidak ada produk dalam stok.");
                return;
            }
            System.out.println("\n===== DAFTAR PRODUK =====");
            for (Product p : stok) {
                p.displayInfo();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("[ERROR] Gagal menampilkan produk: " + e.getMessage());
        }
    }

    static void beliProduk() {
        try {
            System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
            int nomorSeri = sc.nextInt();
            sc.nextLine();

            boolean ditemukan = false;
            for (Product p : stok) {
                if (p.seriesNumber == nomorSeri) {
                    System.out.println("\n[OK] Anda telah membeli produk:");
                    p.displayInfo();
                    stok.remove(p);
                    ditemukan = true;
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("[INFO] Produk dengan nomor seri " + nomorSeri + " tidak ditemukan.");
            }

        } catch (InputMismatchException e) {
            System.out.println("[ERROR] Nomor seri harus berupa angka!");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("[ERROR] Terjadi kesalahan: " + e.getMessage());
        }
    }
}