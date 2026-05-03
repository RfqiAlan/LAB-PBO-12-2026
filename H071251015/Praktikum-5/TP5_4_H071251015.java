public class mainKaryawan {
    public static void main(String[] args) {

        // --- KaryawanTetap ---
        KaryawanTetap pegawai1 = new KaryawanTetap("Budi Santoso", "KT-001", 5000000, 25000);

        // Absen beberapa kali
        for (int i = 0; i < 22; i++) {
            pegawai1.absen();
        }

        System.out.println("=== Karyawan Tetap ===");
        System.out.println("Nama       : " + pegawai1.getNama());
        System.out.println("ID         : " + pegawai1.getIdKaryawan());
        System.out.println("Kehadiran  : " + pegawai1.getJumlahKehadiran() + " hari");
        System.out.printf("Gaji Pokok : Rp%.0f%n", pegawai1.hitungGaji());
        System.out.printf("Gaji + Bonus Rp500.000 : Rp%.0f%n", pegawai1.hitungGaji(500000));

        System.out.println();

        // --- KaryawanKontrak ---
        KaryawanKontrak pegawai2 = new KaryawanKontrak("Siti Aminah", "KK-001", 150000);

        // Absen lebih dari 20 kali agar dapat bonus
        for (int i = 0; i < 23; i++) {
            pegawai2.absen();
        }

        System.out.println("=== Karyawan Kontrak ===");
        System.out.println("Nama       : " + pegawai2.getNama());
        System.out.println("ID         : " + pegawai2.getIdKaryawan());
        System.out.println("Kehadiran  : " + pegawai2.getJumlahKehadiran() + " hari");
        System.out.printf("Total Gaji (termasuk bonus kehadiran) : Rp%.0f%n", pegawai2.hitungGaji());
    }
}