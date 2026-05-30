public class SmartCCTV extends AbstractPerangkatElektronik implements IInteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println(merk + ": SmartCCTV sedang merekam.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}
