abstract class AbstractKaryawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    public AbstractKaryawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        jumlahKehadiran++;
    }

    public int getjumlahKehadiran() {
        return jumlahKehadiran;
    }

    public String getNama() {
        return nama;
    }

    public String getidKaryawan() {
        return idKaryawan;
    }

    abstract double hitungGaji();
}
