class KaryawanKontrak extends  AbstractKaryawan {
    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }
    
    double hitungGaji() {
        double total = upahPerHari * getjumlahKehadiran();
        if (getjumlahKehadiran() > 20) {
            total += 500000;
        }
        return total;
    }
}
