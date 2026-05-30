public abstract class AbstractKaryawan {

    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    public AbstractKaryawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    //method konkrit - tambah kehadiran 1 
    public void absen() {
        jumlahKehadiran++;
        System.out.println(nama + " absen. Total kehadiran: " + jumlahKehadiran);
    }

    //getter untuk diakses subclass
    public String getNama() {
        return nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    //method abstract - akan di isi pada masing' subclass
    public abstract double hitungGaji();
}
