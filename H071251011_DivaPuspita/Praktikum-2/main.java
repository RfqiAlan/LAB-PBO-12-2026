public class main {
    public static void main(String[] args) {
        Pilot pilot1 = new Pilot("Capt Arga", 10, "CPL");
        Pilot pilot2 = new Pilot("Capt Dava", 15, "ATPL");

        Pesawat pesawat1 = new Pesawat("GA123", 180, pilot1);
        Pesawat pesawat2 = new Pesawat("JT456", 220, pilot2);

        pesawat1.infoPesawat();
        System.out.println();
        pesawat2.infoPesawat();
        System.out.println();

        pesawat1.aduKapasitas(pesawat2);
        System.out.println();

        System.out.println("Jumlah data pesawat yang dibuat: " + Pesawat.jumlahPesawat);
    }
}
