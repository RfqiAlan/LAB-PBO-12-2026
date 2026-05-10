// Abstract class untuk identitas fisik perangkat
abstract class PerangkatElektronik {
    protected String merk;
    protected int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi(); // Method abstract

    public void infoPower() {
        System.out.println(merk + " sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }
}