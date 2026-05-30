import java.util.Scanner;

class Tabung extends BangunRuang {
    double jariJari, tinggi;

    Tabung() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jari-jari tabung: ");
        this.jariJari = sc.nextDouble();
        System.out.print("Masukkan tinggi tabung: ");
        this.tinggi = sc.nextDouble();
    }

    @Override
    void hitungLuas() {
        double luas = 2 * Math.PI * jariJari * (jariJari + tinggi);
        System.out.println("Luas tabung: " + luas);
    }

    @Override
    void hitungVolume() {
        double volume = Math.PI * jariJari * jariJari * tinggi;
        System.out.println("Volume tabung: " + volume);
    }
}
