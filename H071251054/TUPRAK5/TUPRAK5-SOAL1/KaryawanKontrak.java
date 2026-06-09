public class KaryawanKontrak extends AbstractKaryawan {

    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * getJumlahKehadiran();

        if (getJumlahKehadiran() > 20) {
            totalGaji += 500000;
            System.out.println("Bonus tambahan Rp500.000 diberikan karena kehadiran > 20 hari.");
        }

        return totalGaji;
    }
}
