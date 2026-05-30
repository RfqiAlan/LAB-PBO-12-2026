import java.util.Scanner;

class Balok extends BangunRuang {
    double panjang, lebar, tinggi;

    Balok() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan panjang balok: ");
        this.panjang = sc.nextDouble();
        System.out.print("Masukkan lebar balok: ");
        this.lebar = sc.nextDouble();
        System.out.print("Masukkan tinggi balok: ");
        this.tinggi = sc.nextDouble();
    }

    @Override
    void hitungLuas() {
        double luas = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
        System.out.println("Luas balok: " + luas);
    }

    @Override
    void hitungVolume() {
        double volume = panjang * lebar * tinggi;
        System.out.println("Volume balok: " + volume);
    }
}
