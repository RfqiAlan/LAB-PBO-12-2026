abstract class AbstractPerangkatElektronik {
    String merk;
    int dayaListrik;

    public AbstractPerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    abstract void cekFungsi();

    void infoPower() {
        System.out.println(merk + " menggunakan daya " + dayaListrik + " watt");
    }  
}
