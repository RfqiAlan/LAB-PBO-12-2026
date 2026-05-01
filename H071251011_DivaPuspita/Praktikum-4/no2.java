import java.util.ArrayList;
import java.util.Scanner;


class Product {
    String brand;
    String serialNumber;
    double price;

    public Product(String brand, String serialNumber, double price) {
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("Produk : " + brand + " | Serial: " + serialNumber + " | Harga: " + price);
    }
}

class Smartphone extends Product {
    double screenSize;
    int storageCapacity;

    public Smartphone(String brand, String serialNumber, double price, double screenSize, int storageCapacity) {
        super(brand, serialNumber, price);
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    void displayInfo() {
        System.out.println("=== Smartphone ===");
        System.out.println("Brand " + brand);
        System.out.println("Serial number " + serialNumber);
        System.out.println("Price " + price);
        System.out.println("Screen Size " + screenSize + " inches");
        System.out.println("Storage Capacity :  " + storageCapacity + "GB\n");
    }
}

class Laptop extends Product {
    String processorType;
    int ramSize;

    public Laptop(String brand, String serialNumber, double price, String processorType, int ramSize) {
        super(brand, serialNumber, price);
        this.processorType = processorType;
        this.ramSize = ramSize;
    }

    void displayInfo(){
        System.out.println("=== Laptop ===");
        System.out.println("Brand " + brand);
        System.out.println("Serial number " + serialNumber);
        System.out.println("Price " + price);
        System.out.println("Processor Type " + processorType);
        System.out.println("RAM  :  " + ramSize + "GB\n");
    }
}

class Camera extends Product {
    int resolution;
    String lensType;

    public Camera(String brand, String serialNumber, double price, int resolution, String lensType) {
        super(brand, serialNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    void displayInfo() {
        System.out.println("=== Camera ===");
        System.out.println("Brand " + brand);
        System.out.println("Serial number " + serialNumber);
        System.out.println("Price " + price);
        System.out.println("Resolution : " + resolution + "MP");
        System.out.println("Lens Type : " + lensType + "\n");
    }
}

public class no2 {
    static ArrayList<Smartphone> listHP = new ArrayList<>();
    static ArrayList<Laptop> listLaptop = new ArrayList<>();
    static ArrayList<Camera> listCamera = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih = 0;
        do { 
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print(">>> Pilih menu (1-4): ");

            try {
                pilih = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Maaff inputan km itu harusnya berupa angka!!!");
                continue;
            }

            if(pilih == 1) tambahProduk();
            else if(pilih == 2) tampilkanProduk();
            else if(pilih == 3) beliProduk();
            else if(pilih == 4) System.out.println("Terima kasih telah menggunakan layanan kami.");
            else System.out.println("Pilihan tidak valid.");
        } while (pilih != 4);
    }

    static void tambahProduk() {
        System.out.print("Masukkan nama produk: ");
        String brand = input.nextLine();

        System.out.print("Masukkan nomor seri: ");
        String seri = input.nextLine();

        double harga = 0;
        while (true) { 
            System.out.print("Masukkan harganya : ");

            try {
                harga = Double.parseDouble(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("MAAFF input km harus angka!! ");
            }
        }

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone\n2. Laptop\n3. Camera");
        int tipe = 0;
        while (true) { 
            System.out.print("Pilih tipe produk (1-3): \n");
            try {
                tipe = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("MAAFF input km harus angka!! ");
            }
        }

        if(tipe == 1){
            double screen = 0;
            int storage = 0;

            while (true) { 
                try {
                System.out.print("Masukkan ukuran layar (inci): ");
                screen = Double.parseDouble(input.nextLine());

                System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                storage = Integer.parseInt(input.nextLine());
                break;
                } catch (NumberFormatException e) {
                    System.out.println("MAAFF input km harus angka!! ");
                }
            }

            listHP.add(new Smartphone(brand, seri, harga, screen, storage));

        } else if(tipe == 2){
            System.out.print("Masukkan processor: ");
            String proc =input.nextLine();

            int ram = 0;
            while (true) { 
                try {
                    System.out.print("Masukkan RAM (GB): ");
                    ram = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Maff input km harus angka!!!");
                }
            }
            listLaptop.add(new Laptop(brand, seri, harga, proc, ram));

        } else if(tipe == 3){
            int res = 0;
            while(true) {
                try {
                    System.out.print("Masukkan resolusi kamera (MP) : ");
                    res = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("MAAFF input km harus angka!!");
                }
            }
            System.out.print("Masukkan jenis lensa: ");
            String lens = input.nextLine();

            listCamera.add(new Camera(brand, seri, harga, res, lens));
        }
    }

    static void tampilkanProduk() {
        System.out.println("\nDaftar Produk:");
        
        if(listHP.isEmpty() && listLaptop.isEmpty() && listCamera.isEmpty()) {
            System.out.print("Belum ada produk yang kamu masukkan\n");
            return;
        } 

        //ini toh adalah for each loop yang artinya ambil stiap objek Smartphone yang ada di listHP kemudian simpan smntra ke variabel c baru jalankan displayInfo bgitupun seterusnya
        if(listHP.isEmpty() && listLaptop.isEmpty() && listCamera.isEmpty()) {
            System.out.println("Belum ada produk yang kamu masukkan");
            return;
        }
        
        for (Smartphone s : listHP) {
            s.displayInfo();
        }

        for (Laptop l : listLaptop) {
            l.displayInfo();
        }

        for (Camera c : listCamera) {
            c.displayInfo();
        }
    }

    static void beliProduk() {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        String seri = input.nextLine();

        boolean found = false;

        for (Smartphone s : listHP) {
            if (s.serialNumber.equals(seri)) {
                System.out.println("Anda membeli:");
                s.displayInfo();
                found = true;
            }
        }

        for (Laptop l : listLaptop) {
            if (l.serialNumber.equals(seri)) {
                System.out.println("Anda membeli:");
                l.displayInfo();
                found = true;
            }
        }

        for (Camera c : listCamera) {
            if (c.serialNumber.equals(seri)) {
                System.out.println("Anda membeli:");
                c.displayInfo();
                found = true;
            }
        }
        if(!found) System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
    }
}
