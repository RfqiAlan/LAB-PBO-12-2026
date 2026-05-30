public abstract class AbstractPerangkatElektronik {

    protected String merk;
    protected int dayaListrik;

    public AbstractPerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public void infoPower() { 
        System.out.println(merk + " sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }

    public abstract void cekFungsi(); 
}
