public class DompetDigital {
    protected  String idNasabah;
    private String pin;
    private double saldo; //jika tidak mau berakhiran .0 maka gnti double mnjd
    String modeOperasi = "Normal";
    
    public DompetDigital (String idNasabah, String pin, double saldo) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    } 

    public String getidNasabah() {
        return idNasabah;
    }

    public void setidNasabah(String idNasabahLama, String idNasabahBaru) {
        if(!this.idNasabah.equals(idNasabahLama)) {
            catatTransaksi("Ubah idNasabah gagal, idNasabah lama yang Anda masukkan salah!!!");
        }
        this.idNasabah = idNasabahBaru;
        catatTransaksi("idNasabah Anda berhasil di ubah");
    }

    public String getmodeOperasi() {
        return modeOperasi;
    }

    public void setmodeOperasi(String mode) {
        this.modeOperasi = mode;
    }

    public boolean setPin(String pinLama, String pinBaru) {
        if(!this.pin.equals(pinLama)) {
            catatTransaksi("Ubah PIN gagal, PIN lama yang Anda masukkan salah!!!");
            return false;
        }
        if(pinBaru.length() != 6) {
            catatTransaksi("Ubah PIN gagal, PIN baru harus berisi 6 digit");
            return false;
        }
        this.pin = pinBaru;
        catatTransaksi("PIN Anda berhasil diubah");
        return true;
    }

    public boolean setorTunai(double jumlah) {
        if (jumlah <= 0) {
            catatTransaksi("Setor tunai Anda gagal karena nominal tidak valid");
            return false;
        }
        saldo += jumlah;
        catatTransaksi("Setor tunai berhasil : + " + jumlah);
        return true;
    }

    public boolean tarikTunai(double jumlah, String pinInput) {
        if(modeOperasi.equals("Maintenance")) {
            catatTransaksi(("Transaksi ditolak sistem sedang maintenance"));
            return false;
        }

        if(!pin.equals(pinInput)) {
            catatTransaksi("Tarik tunai Anda gagal karena PIN yang Anda masukkan salah");
            return false;
        }
        if(saldo < jumlah) {
            catatTransaksi("Tarik tunai Anda gagal karena saldo Anda tidak cukup");
            return false;
        }
        saldo -= jumlah;
        catatTransaksi("Tarik tunai berhasil : -" + jumlah);
        return true;
    }

    private void catatTransaksi(String pesan) {
        System.out.println("[CATATAN] " + pesan);
    }
}
