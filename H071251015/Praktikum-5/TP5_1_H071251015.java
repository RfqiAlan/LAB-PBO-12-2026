// Abstract class sebagai pilar abstraction
abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
    }

    // Method konkrit untuk menambah kehadiran
    public void absen() {
        this.jumlahKehadiran += 1;
    }

    // Abstract method tanpa body
    public abstract double hitungGaji();

    public String getNama() {
        return nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }
}