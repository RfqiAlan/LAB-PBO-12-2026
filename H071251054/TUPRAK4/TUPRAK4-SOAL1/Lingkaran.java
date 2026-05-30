import java.util.Scanner;

class Lingkaran extends BangunDatar {
    double jariJari;

    Lingkaran() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jari-jari lingkaran: ");
        this.jariJari = sc.nextDouble();
    }

    @Override
    void hitungLuas() {
        double luas = Math.PI * jariJari * jariJari;
        System.out.println("Luas lingkaran: " + luas);
    }

    @Override
    void hitungKeliling() {
        double keliling = 2 * Math.PI * jariJari;
        System.out.println("Keliling lingkaran: " + keliling);
    }
}
