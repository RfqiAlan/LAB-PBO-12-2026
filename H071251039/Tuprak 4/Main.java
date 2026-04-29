import java.util.Scanner;

interface Bangun {
    double luas();
    void info();
}

interface BangunRuangInterface extends Bangun {
    double volume();
}

interface BangunDatarInterface extends Bangun {
    double keliling();
}

class Kubus implements BangunRuangInterface {
    private double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double luas() {
        return 6 * sisi * sisi;
    }

    @Override
    public double volume() {
        return sisi * sisi * sisi;
    }

    @Override
    public void info() {
        System.out.println("Luas Permukaan Kubus : " + luas());
        System.out.println("Volume Kubus         : " + volume());
    }
}

class Balok implements BangunRuangInterface {
    private double panjang, lebar, tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar   = lebar;
        this.tinggi  = tinggi;
    }

    @Override
    public double luas() {
        return 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    }

    @Override
    public double volume() {
        return panjang * lebar * tinggi;
    }

    @Override
    public void info() {
        System.out.println("Luas Permukaan Balok : " + luas());
        System.out.println("Volume Balok         : " + volume());
    }
}

class Bola implements BangunRuangInterface {
    private double jariJari;

    public Bola(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double luas() {
        return 4 * Math.PI * jariJari * jariJari;
    }

    @Override
    public double volume() {
        return (4.0 / 3) * Math.PI * jariJari * jariJari * jariJari;
    }

    @Override
    public void info() {
        System.out.printf("Luas Permukaan Bola  : %.2f%n", luas());
        System.out.printf("Volume Bola          : %.2f%n", volume());
    }
}

class Tabung implements BangunRuangInterface {
    private double jariJari, tinggi;

    public Tabung(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi   = tinggi;
    }

    @Override
    public double luas() {
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }

    @Override
    public double volume() {
        return Math.PI * jariJari * jariJari * tinggi;
    }

    @Override
    public void info() {
        System.out.printf("Luas Permukaan Tabung : %.2f%n", luas());
        System.out.printf("Volume Tabung         : %.2f%n", volume());
    }
}

class Persegi implements BangunDatarInterface {
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double luas() {
        return sisi * sisi;
    }

    @Override
    public double keliling() {
        return 4 * sisi;
    }

    @Override
    public void info() {
        System.out.println("Luas Persegi     : " + luas());
        System.out.println("Keliling Persegi : " + keliling());
    }
}

class PersegiPanjang implements BangunDatarInterface {
    private double panjang, lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar   = lebar;
    }

    @Override
    public double luas() {
        return panjang * lebar;
    }

    @Override
    public double keliling() {
        return 2 * (panjang + lebar);
    }

    @Override
    public void info() {
        System.out.println("Luas Persegi Panjang     : " + luas());
        System.out.println("Keliling Persegi Panjang : " + keliling());
    }
}

class Lingkaran implements BangunDatarInterface {
    private double jariJari;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double luas() {
        return Math.PI * jariJari * jariJari;
    }

    @Override
    public double keliling() {
        return 2 * Math.PI * jariJari;
    }

    @Override
    public void info() {
        System.out.printf("Luas Lingkaran     : %.2f%n", luas());
        System.out.printf("Keliling Lingkaran : %.2f%n", keliling());
    }
}

class Trapesium implements BangunDatarInterface {
    private double sisi1, sisi2, sisi3, sisi4, tinggi;

    public Trapesium(double sisi1, double sisi2, double sisi3, double sisi4, double tinggi) {
        this.sisi1  = sisi1;
        this.sisi2  = sisi2;
        this.sisi3  = sisi3;
        this.sisi4  = sisi4;
        this.tinggi = tinggi;
    }

    @Override
    public double luas() {
        return 0.5 * (sisi1 + sisi2) * tinggi;
    }

    @Override
    public double keliling() {
        return sisi1 + sisi2 + sisi3 + sisi4;
    }

    @Override
    public void info() {
        System.out.println("Luas Trapesium     : " + luas());
        System.out.println("Keliling Trapesium : " + keliling());
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void tampilkanMenu() {
        System.out.println("----------------------------------------");
        System.out.println("  ===== BANGUN RUANG =====");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");
        System.out.println();
        System.out.println("  ===== BANGUN DATAR =====");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("----------------------------------------");
        System.out.print("Pilihan: ");
    }

    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            String pilihan = sc.nextLine().trim();
            System.out.println("----------------------------------------");

            switch (pilihan) {
                case "1": {
                    System.out.print("Masukkan sisi kubus: ");
                    double sisi = Double.parseDouble(sc.nextLine());
                    new Kubus(sisi).info();
                    break;
                }
                case "2": {
                    System.out.print("Masukkan panjang balok: ");
                    double panjang = Double.parseDouble(sc.nextLine());
                    System.out.print("Masukkan lebar balok: ");
                    double lebar = Double.parseDouble(sc.nextLine());
                    System.out.print("Masukkan tinggi balok: ");
                    double tinggi = Double.parseDouble(sc.nextLine());
                    new Balok(panjang, lebar, tinggi).info();
                    break;
                }
                case "3": {
                    System.out.print("Masukkan jari-jari bola: ");
                    double jariJari = Double.parseDouble(sc.nextLine());
                    new Bola(jariJari).info();
                    break;
                }
                case "4": {
                    System.out.print("Masukkan jari-jari tabung: ");
                    double jariJari = Double.parseDouble(sc.nextLine());
                    System.out.print("Masukkan tinggi tabung: ");
                    double tinggi = Double.parseDouble(sc.nextLine());
                    new Tabung(jariJari, tinggi).info();
                    break;
                }
                case "5": {
                    System.out.print("Masukkan sisi persegi: ");
                    double sisi = Double.parseDouble(sc.nextLine());
                    new Persegi(sisi).info();
                    break;
                }
                case "6": {
                    System.out.print("Masukkan panjang: ");
                    double panjang = Double.parseDouble(sc.nextLine());
                    System.out.print("Masukkan lebar: ");
                    double lebar = Double.parseDouble(sc.nextLine());
                    new PersegiPanjang(panjang, lebar).info();