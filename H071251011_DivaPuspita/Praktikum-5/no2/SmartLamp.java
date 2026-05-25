class SmartLamp extends AbstractPerangkatElektronik implements IKontrolSuara {
    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }
    
    @Override
    void cekFungsi() {
        System.out.println("Lampu berfungsi dengan baik");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if(perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu menyala");
        } else {
            System.out.println("Perintah tidak dikenali");
        }
    }
}
