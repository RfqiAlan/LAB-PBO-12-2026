import java.util.Scanner;

class PersegiPanjang extends BangunDatar {
    double panjang, lebar;

    PersegiPanjang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan panjang persegi panjang: ");
        this.panjang = sc.nextDouble();
        System.out.print("Masukkan lebar persegi panjang: ");
        this.lebar = sc.nextDouble();
    }

    @Override
    void hitungLuas() {
        double luas = panjang * lebar;
        System.out.println("Luas persegi panjang: " + luas);
    }

    @Override
    void hitungKeliling() {
        double keliling = 2 * (panjang + lebar);
        System.out.println("Keliling persegi panjang: " + keliling);
    }
}
