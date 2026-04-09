public class Pilot {
    String nama;   
    int pengalaman;
    String lisensi;

    public Pilot() {
        this.nama = "UNKNOWN";
        this.pengalaman = 0;
        this.lisensi = "NONE";
    }

    public Pilot(String nama, int pengalaman, String lisensi) {
        this.nama = nama;              
        this.pengalaman = pengalaman;
        this.lisensi = lisensi;
    }

    public String infoPilot() {
        return "Pilot " + nama + " dengan " + pengalaman + " tahun pengalaman dengan lisensi " + lisensi;
    }
}

