public class main1 {
    public static void main(String[] args) {
        KaryawanTetap tetap = new KaryawanTetap("Diva", "div123", 3000000.0, 100000);
        for (int i = 0; i < 22; i++) {
            tetap.absen();
            System.out.println(tetap.getjumlahKehadiran());
        }
        System.out.println("=== KARYAWAN TETAP ===");
        System.out.println("Nama           : " + tetap.getNama());
        System.out.println("ID             : " + tetap.getidKaryawan());
        System.out.println("Kehadiran      : " + tetap.getjumlahKehadiran());
        System.out.println("Gaji + Bonus   : " + tetap.hitungGaji(1000000));

        System.out.println("\n");
        

        KaryawanKontrak kontrak = new KaryawanKontrak("Caca", "cac456", 50000);
        for (int i = 0; i < 21; i++) {
            kontrak.absen();
        }
        
        System.out.println("=== KARYAWAN KONTRAK ===");
        System.out.println("Nama      : " + kontrak.getNama());
        System.out.println("ID        : " + kontrak.getidKaryawan());
        System.out.println("Kehadiran : " + kontrak.getjumlahKehadiran());
        System.out.println("Gaji      : " + kontrak.hitungGaji());
    }
}
