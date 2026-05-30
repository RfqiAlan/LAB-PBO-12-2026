import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
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
            int pilihan = sc.nextInt();
            System.out.println("----------------------------------------");

            if (pilihan == 1) {
                Kubus kubus = new Kubus();
                kubus.hitungLuas();
                kubus.hitungVolume();
            } else if (pilihan == 2) {
                Balok balok = new Balok();
                balok.hitungLuas();
                balok.hitungVolume();
            } else if (pilihan == 3) {
                Bola bola = new Bola();
                bola.hitungLuas();
                bola.hitungVolume();
            } else if (pilihan == 4) {
                Tabung tabung = new Tabung();
                tabung.hitungLuas();
                tabung.hitungVolume();
            } else if (pilihan == 5) {
                Persegi persegi = new Persegi();
                persegi.hitungLuas();
                persegi.hitungKeliling();
            } else if (pilihan == 6) {
                PersegiPanjang pp = new PersegiPanjang();
                pp.hitungLuas();
                pp.hitungKeliling();
            } else if (pilihan == 7) {
                Lingkaran lingkaran = new Lingkaran();
                lingkaran.hitungLuas();
                lingkaran.hitungKeliling();
            } else if (pilihan == 8) {
                Trapesium trapesium = new Trapesium();
                trapesium.hitungLuas();
                trapesium.hitungKeliling();
            } else {
                System.out.println("Pilihan tidak valid!");
            }
            System.out.println("----------------------------------------");
        }
    }
}
