class KaryawanKontrak extends Karyawan {
    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * getJumlahKehadiran();
        // Bonus flat jika kerja > 20 hari
        if (getJumlahKehadiran() > 20) {
            totalGaji = totalGaji + 500000;
        }
        return totalGaji;
    }
}