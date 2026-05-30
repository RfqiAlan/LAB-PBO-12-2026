public class Main {
    public static void main(String[] args) {

        //karyawan tetap
        System.out.println("=== Karyawan Tetap ===");
        KaryawanTetap budi = new KaryawanTetap("Budi", "KT001", 5000000, 25000);

        budi.absen();
        budi.absen();
        budi.absen();

        double bonusKinerja = 1000000;
        double totalGajiBudi = budi.hitungGaji(bonusKinerja);
        System.out.println("Total Gaji Budi (dengan bonus): Rp" + totalGajiBudi);

        // double totalGajiBudi = budi.hitungGaji();
        // System.out.println("Total Gaji Budi: Rp" + totalGajiBudi);

        //karyawan kontrak
        System.out.println("\n=== Karyawan Kontrak ===");
        KaryawanKontrak rina = new KaryawanKontrak("Rina", "KK001", 200000);

        //absen lebih dari 20 kali
        for (int i = 0; i < 22; i++) {
            rina.absen();
        }

        double totalGajiRina = rina.hitungGaji();
        System.out.println("Total Gaji Rina: Rp" + totalGajiRina);
    }
}
