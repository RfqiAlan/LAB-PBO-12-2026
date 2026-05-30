import java.util.Scanner;

class Persegi extends BangunDatar {
    Persegi() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan sisi persegi: ");
        this.sisi = sc.nextDouble();
    }

    @Override
    void hitungLuas() {
        double luas = sisi * sisi;
        System.out.println("Luas persegi: " + luas);
    }

    @Override
    void hitungKeliling() {
        double keliling = 4 * sisi;
        System.out.println("Keliling persegi: " + keliling);
    }
}
