class SmartCCTV extends AbstractPerangkatElektronik implements IInteraksiInternet, IKontrolSuara {
    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("CCTV berfungsi dengan baik");
    }

    @Override
    public void hubungkanWifi() {
        System.out.println("CCTV terhubung ke WIFI dan mengirim data ke server");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equals("nyalakan")) {
            System.out.println("CCTV dinyalakan");
        } else if (perintah.equals("matikan")) {
            System.out.println("CCTV dimatikan");
        } else {
            System.out.println("Perintah tidak dikenali");
        }
    }
}
