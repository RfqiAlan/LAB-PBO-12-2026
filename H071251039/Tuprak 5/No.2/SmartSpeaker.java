public class SmartSpeaker extends AbstrakPerangkatElektronik implements IInteraksiInternet, IKontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println(getMerk() + " SmartSpeaker siap memutar musik.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println(getMerk() + " terhubung ke WiFi.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println(getMerk() + " memproses perintah: " + perintah);
    }
}
