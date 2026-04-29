import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produk {
    protected String merek;
    protected int    nomorSeri;
    protected double harga;

    public Produk(String merek, int nomorSeri, double harga) {
        this.merek     = merek;
        this.nomorSeri = nomorSeri;
        this.harga     = harga;
    }

    public void tampilkanInfo() {
        System.out.println("Merek        : " + merek);
        System.out.println("Nomor Seri   : " + nomorSeri);
        System.out.println("Harga        : $" + harga);
    }
}

class Smartphone extends Produk {
    private double ukuranLayar;
    private int    kapasitasPenyimpanan;

    public Smartphone(String merek, int nomorSeri, double harga,
                      double ukuranLayar, int kapasitasPenyimpanan) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar          = ukuranLayar;
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran Layar          : " + ukuranLayar + " inci");
        System.out.println("Kapasitas Penyimpanan : " + kapasitasPenyimpanan + "GB");
    }
}

class Laptop extends Produk {
    private int    ukuranRAM;
    private String tipeProsesor;

    public Laptop(String merek, int nomorSeri, double harga,
                  int ukuranRAM, String tipeProsesor) {
        super(merek, nomorSeri, harga);
        this.ukuranRAM   = ukuranRAM;
        this.tipeProsesor = tipeProsesor;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe Prosesor : " + tipeProsesor);
        System.out.println("Ukuran RAM    : " + ukuranRAM + "GB");
    }
}

class Kamera extends Produk {
    private int    resolusi;
    private String tipeLensa;

    public Kamera(String merek, int nomorSeri, double harga,
                  int resolusi, String tipeLensa) {
        super(merek, nomorSeri, harga);
        this.resolusi  = resolusi;
        this.tipeLensa = tipeLensa;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Resolusi   : " + resolusi + "MP");
        System.out.println("Tipe Lensa : " + tipeLensa);
    }
}

class Toko {
    private List<Produk> daftarProduk = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public Toko() {
        daftarProduk.add(new Smartphone("Samsung", 123456, 899.99, 6.5, 256));
        daftarProduk.add(new Laptop("Dell", 987654, 1299.99, 16, "Intel Core i7"));
        daftarProduk.add(new Kamera("Canon", 456789, 699.99, 24, "Telephoto"));
    }

    private void tampilkanMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Keluar");
    }

    private void tambahProduk() {
        System.out.print("Masukkan nama produk: ");
        String merek = sc.nextLine();

        System.out.print("Masukkan nomor seri: ");
        int nomorSeri = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Masukkan harga: ");
        double harga = Double.parseDouble(sc.nextLine().trim());

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Kamera");
        System.out.print("Pilih tipe produk (1-3): ");
        String tipe = sc.nextLine().trim();

        switch (tipe) {
            case "1": {
                System.out.print("Masukkan ukuran layar (inci): ");
                double layar = Double.parseDouble(sc.nextLine().trim());
                System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                int penyimpanan = Integer.parseInt(sc.nextLine().trim());
                daftarProduk.add(new Smartphone(merek, nomorSeri, harga, layar, penyimpanan));
                break;
            }
            case "2": {
                System.out.print("Masukkan ukuran RAM (GB): ");
                int ram = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Masukkan tipe prosesor: ");
                String prosesor = sc.nextLine();
                daftarProduk.add(new Laptop(merek, nomorSeri, harga, ram, prosesor));
                break;
            }
            case "3": {
                System.out.print("Masukkan resolusi (MP): ");
                int resolusi = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Masukkan tipe lensa: ");
                String lensa = sc.nextLine();
                daftarProduk.add(new Kamera(merek, nomorSeri, harga, resolusi, lensa));
                break;
            }
            default:
                System.out.println("Tipe produk tidak valid.");
        }
    }

    private void tampilkanSemuaProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Stok kosong.");
            return;
        }
        System.out.println("Daftar Produk:");
        for (Produk p : daftarProduk) {
            p.tampilkanInfo();
            System.out.println();
        }
    }

    private void beliProduk() {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int nomorCari = Integer.parseInt(sc.nextLine().trim());

        for (Produk p : daftarProduk) {
            if (p.nomorSeri == nomorCari) {
                System.out.println("Anda telah membeli produk:");
                p.tampilkanInfo();
                return;
            }
        }
        System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
    }

    public void jalankan() {
        while (true) {
            tampilkanMenu();
            System.out.print(">>> Pilih menu (1-4):  ");
            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1":
                    tambahProduk();
                    break;
                case "2":
                    tampilkanSemuaProduk();
                    break;
                case "3":
                    beliProduk();
                    break;
                case "4":
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-4.");
            }
        }
    }
}

public class TokoElektronik {
    public static void main(String[] args) {
        Toko toko = new Toko();
        toko.jalankan();
    }
}
