public class SmartSpeaker extends AbstractPerangkatElektronik implements IInteraksiInternet, IKontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println(merk + ": SmartSpeaker siap memutar audio.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println(merk + ": Terhubung ke WiFi untuk streaming.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println(merk + " menerima perintah: " + perintah);
    }
}
