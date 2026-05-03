class SmartLamp extends PerangkatElektronik implements kontrolsuara {
    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Lampu siap digunakan.");
    }

    @Override
    public void prosesperintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        } else {
            System.out.println("Perintah tidak dikenali.");
        }
    }
}