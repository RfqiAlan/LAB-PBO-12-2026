//class itu toh kita ibaratkan saja sebagai bahan mentah krn ia belum jd objek nyata, kek ji semacam panduan bmna sebuah objek itu terbentuk
public class Pesawat {
    String kodePenerbangan;   
    int kapasitasPenumpang;
    Pilot pilot;
    static int jumlahPesawat = 0;   

    public Pesawat() {
        this.kodePenerbangan = "UNKNOWN";
        this.kapasitasPenumpang = 0;
        this.pilot = null;
        jumlahPesawat++;
    }

    public Pesawat(String kodePenerbangan, int kapasitasPenumpang, Pilot pilot) {
        this.kodePenerbangan = kodePenerbangan;   
        this.kapasitasPenumpang = kapasitasPenumpang;
        this.pilot = pilot;
        jumlahPesawat++;
    }

    public void infoPesawat() {
        System.out.println("Pesawat " + kodePenerbangan + " berkapasitas " + kapasitasPenumpang);
        if (pilot != null) {
            System.out.println("Dikemudikan oleh : " + pilot.infoPilot());
        } else {
            System.out.println("Pilot belum ditentukan");
        }
    }

    public void aduKapasitas(Pesawat lawan) {
        if (this.kapasitasPenumpang > lawan.kapasitasPenumpang) {
    System.out.println("Pesawat " + kodePenerbangan + 
        " memiliki kapasitas lebih besar (" + kapasitasPenumpang + 
        " vs " + lawan.kapasitasPenumpang + ")");
    } else if (this.kapasitasPenumpang < lawan.kapasitasPenumpang) {
    System.out.println("Pesawat " + lawan.kodePenerbangan + 
        " memiliki kapasitas lebih besar (" + lawan.kapasitasPenumpang + 
        " vs " + kapasitasPenumpang + ")");
    } else {
    System.out.println("Kapasitas kedua pesawat sama.");
    }
  }
}
