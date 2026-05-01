class KaryawanTetap extends AbstractKaryawan {
    private double gajiPokok;
    private double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    double hitungGaji() {
        return gajiPokok + (tunjanganMakan * getjumlahKehadiran());
    }

    double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}
