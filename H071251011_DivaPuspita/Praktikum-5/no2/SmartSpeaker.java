class SmartSpeaker extends AbstractPerangkatElektronik implements IInteraksiInternet, IKontrolSuara {
    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Speaker berfungsi dengan baik");
    }

    @Override
    public void hubungkanWifi() {
        System.out.println("Speaker terhubung ke WIFI");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Speaker " + perintah + "\n");
    }
}
