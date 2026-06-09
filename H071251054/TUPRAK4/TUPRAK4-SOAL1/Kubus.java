import java.util.Scanner;

class Kubus extends BangunRuang { 
    Kubus() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan sisi kubus: ");
        this.sisi = sc.nextDouble(); 
    }

    @Override
    void hitungLuas() { 
        double luas = 6 * sisi * sisi; 
        System.out.println("Luas kubus: " + luas);
    }

    @Override
    void hitungVolume() {
        double volume = sisi * sisi * sisi;
        System.out.println("Volume kubus: " + volume);
    }
}
