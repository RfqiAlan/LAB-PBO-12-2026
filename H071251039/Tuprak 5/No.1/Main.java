public class Main{
    public static void main(String[] args) {

        KaryawanTetap karyawan1 = new KaryawanTetap("Budi", "KT-001", 5000000, 50000);

        for (int i = 0; i < 15; i++) {
            karyawan1.absen();
        }

        System.out.println("=== KARYAWAN TETAP ===");
        System.out.println("Nama         : " + karyawan1.getNama());
        System.out.println("ID           : " + karyawan1.getIdKaryawan());
        System.out.println("Kehadiran    : " + karyawan1.getJumlahKehadiran() + " hari");
        System.out.println("Gaji Normal  : Rp" + karyawan1.hitungGaji());
        System.out.println("Gaji + Bonus : Rp" + karyawan1.hitungGaji(1000000));

        System.out.println();

        KaryawanKontrak karyawan2 = new KaryawanKontrak("Siti", "KK-001", 200000);

        for (int i = 0; i < 22; i++) {
            karyawan2.absen();
        }

        System.out.println("=== KARYAWAN KONTRAK ===");
        System.out.println("Nama         : " + karyawan2.getNama());
        System.out.println("ID           : " + karyawan2.getIdKaryawan());
        System.out.println("Kehadiran    : " + karyawan2.getJumlahKehadiran() + " hari");
        System.out.println("Total Gaji   : Rp" + karyawan2.hitungGaji());
    }
}
