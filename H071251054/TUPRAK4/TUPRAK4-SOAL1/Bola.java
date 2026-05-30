import java.util.Scanner;

class Bola extends BangunRuang {
    double jariJari;

    Bola() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jari-jari bola: ");
        this.jariJari = sc.nextDouble();
    }

    @Override
    void hitungLuas() {
        double luas = 4 * Math.PI * jariJari * jariJari;
        System.out.println("Luas bola: " + luas);
    }

    @Override
    void hitungVolume() {
        double volume = (4.0 / 3) * Math.PI * jariJari * jariJari * jariJari;
        System.out.println("Volume bola: " + volume);
    }
}
