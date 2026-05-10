// SmartSpeaker: turunan PerangkatElektronik, implementasi KEDUA interface
class smartspeaker extends PerangkatElektronik implements interaksiInternet, kontrolsuara {

    public smartspeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Speaker standby.");
    }

    @Override
    public void hubungkanwifi() {
        System.out.println("Speaker terhubung internet.");
    }

    @Override
    public void prosesperintah (String perintah) {
        System.out.println("Speaker menjalankan perintah: ");
    }
}