public abstract class AbstrakPerangkatElektronik {

    private String merk;
    private int dayaListrik;

    public AbstrakPerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi();

    public void infoPower() {
        System.out.println(merk + " sedang menyedot daya sebesar " + dayaListrik + " Watt");
    }

    public String getMerk() {
        return merk;
    }
}
