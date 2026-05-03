public class smartcctv extends PerangkatElektronik implements interaksiInternet {

    public smartcctv(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("CCTV memantau...");
    }

    @Override
    public void hubungkanwifi() {
        System.out.println("Mengirim data ke server...");
    }
}