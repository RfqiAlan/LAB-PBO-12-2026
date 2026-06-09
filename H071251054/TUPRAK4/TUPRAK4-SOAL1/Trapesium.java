import java.util.Scanner;

class Trapesium extends BangunDatar { 
    double sisi1, sisi2, sisi3, sisi4, tinggi;

    Trapesium() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan sisi 1 trapesium: ");
        this.sisi1 = sc.nextDouble(); 
        System.out.print("Masukkan sisi 2 trapesium: ");
        this.sisi2 = sc.nextDouble();
        System.out.print("Masukkan sisi 3 trapesium: ");
        this.sisi3 = sc.nextDouble();
        System.out.print("Masukkan sisi 4 trapesium: ");
        this.sisi4 = sc.nextDouble();
        System.out.print("Masukkan tinggi trapesium: ");
        this.tinggi = sc.nextDouble();
    }

    @Override
    void hitungLuas() {
        double luas = 0.5 * (sisi1 + sisi2) * tinggi;
        System.out.println("Luas trapesium: " + luas);
    }

    @Override
    void hitungKeliling() {
        double keliling = sisi1 + sisi2 + sisi3 + sisi4;
        System.out.println("Keliling trapesium: " + keliling);
    }
}
