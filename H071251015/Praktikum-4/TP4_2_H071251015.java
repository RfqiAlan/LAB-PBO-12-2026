import java.util.Scanner;

public class mainBangunDatarRuang {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            System.out.print("Pilihan: ");
            int pilihan = sc.nextInt();
            System.out.println("----------------------------------------");

            switch (pilihan) {
                case 1: prosesKubus(); break;
                case 2: prosesBalok(); break;
                case 3: prosesBola(); break;
                case 4: prosesTabung(); break;
                case 5: prosesPersegi(); break;
                case 6: prosesPersegiPanjang(); break;
                case 7: prosesLingkaran(); break;
                case 8: prosesTrapesium(); break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println("----------------------------------------");
        }
    }

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
    }

    static void prosesKubus() {
        System.out.print("Masukkan sisi kubus: ");
        double sisi = sc.nextDouble();
        Kubus k = new Kubus(sisi);
        System.out.println("Luas permukaan kubus: " + k.hitungLuas());
        System.out.println("Volume kubus: " + k.hitungVolume());
    }

    static void prosesBalok() {
        System.out.print("Masukkan panjang balok: ");
        double p = sc.nextDouble();
        System.out.print("Masukkan lebar balok: ");
        double l = sc.nextDouble();
        System.out.print("Masukkan tinggi balok: ");
        double t = sc.nextDouble();
        Balok b = new Balok(p, l, t);
        System.out.println("Luas permukaan balok: " + b.hitungLuas());
        System.out.println("Volume balok: " + b.hitungVolume());
    }

    static void prosesBola() {
        System.out.print("Masukkan jari-jari bola: ");
        double r = sc.nextDouble();
        Bola b = new Bola(r);
        System.out.println("Luas permukaan bola: " + b.hitungLuas());
        System.out.println("Volume bola: " + b.hitungVolume());
    }

    static void prosesTabung() {
        System.out.print("Masukkan jari-jari tabung: ");
        double r = sc.nextDouble();
        System.out.print("Masukkan tinggi tabung: ");
        double t = sc.nextDouble();
        Tabung tb = new Tabung(r, t);
        System.out.println("Luas permukaan tabung: " + tb.hitungLuas());
        System.out.println("Volume tabung: " + tb.hitungVolume());
    }

    static void prosesPersegi() {
        System.out.print("Masukkan sisi persegi: ");
        double sisi = sc.nextDouble();
        Persegi p = new Persegi(sisi);
        System.out.println("Luas persegi: " + p.hitungLuas());
        System.out.println("Keliling persegi: " + p.hitungKeliling());
    }

    static void prosesPersegiPanjang() {
        System.out.print("Masukkan panjang: ");
        double panjang = sc.nextDouble();
        System.out.print("Masukkan lebar: ");
        double lebar = sc.nextDouble();
        PersegiPanjang pp = new PersegiPanjang(panjang, lebar);
        System.out.println("Luas persegi panjang: " + pp.hitungLuas());
        System.out.println("Keliling persegi panjang: " + pp.hitungKeliling());
    }

    static void prosesLingkaran() {
        System.out.print("Masukkan jari-jari lingkaran: ");
        double r = sc.nextDouble();
        Lingkaran l = new Lingkaran(r);
        System.out.println("Luas lingkaran: " + l.hitungLuas());
        System.out.println("Keliling lingkaran: " + l.hitungKeliling());
    }

    static void prosesTrapesium() {
        System.out.print("Masukkan sisi 1 trapesium: ");
        double s1 = sc.nextDouble();
        System.out.print("Masukkan sisi 2 trapesium: ");
        double s2 = sc.nextDouble();
        System.out.print("Masukkan sisi 3 trapesium: ");
        double s3 = sc.nextDouble();
        System.out.print("Masukkan sisi 4 trapesium: ");
        double s4 = sc.nextDouble();
        System.out.print("Masukkan tinggi trapesium: ");
        double t = sc.nextDouble();
        Trapesium tr = new Trapesium(s1, s2, s3, s4, t);
        System.out.println("Luas trapesium: " + tr.hitungLuas());
        System.out.println("Keliling trapesium: " + tr.hitungKeliling());
    }
}