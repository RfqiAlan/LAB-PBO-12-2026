public class DompetDigital{
    //atribut
    private String pin; 
    private double saldo; //double untuk bilangan desimal
    protected String namaNasabah; 
    String idNasabah; 

    // 2. Constructor 
    public DompetDigital(String idNasabah, String namaNasabah, String pinAwal) {
        this.idNasabah = idNasabah;
        this.namaNasabah = namaNasabah;
        this.pin = pinAwal;
        this.saldo = 0; 
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public double getSaldo() { 
        return saldo;
    }

    public void setpin(String pin){
        this.pin = pin;
        System.out.println("pin telah di ubah");
    }

    public void setPin(String pinLama, String pinBaru) {
        if (this.pin.equals(pinLama)) {
            if (pinBaru.length() == 6) { 
                this.pin = pinBaru;
                System.out.println("Sistem: PIN Berhasil Diperbarui.");
                catatLog("Perubahan PIN Berhasil.");
                System.out.println("pin anda sekarang telah di ubah" + this.pin);
            } else {
                System.out.println("Sistem: Gagal! PIN baru harus tepat 6 karakter.");
                catatLog("Perubahan PIN gagal (Format Salah).");
            }
        } else {
            System.out.println("Sistem: Gagal! PIN lama salah.");
            catatLog("Perubahan PIN gagal (PIN lama salah).");
        }
    }

    public void setorTunai(double nominal) {
        if (nominal <= 0) {
            System.out.println("Sistem: Gagal! Nominal setor harus lebih dari 0.");
            catatLog("Setor tunai gagal (Nominal tidak valid).");
        } else {
            this.saldo += nominal;
            System.out.println("Sistem: Berhasil setor tunai Rp" + nominal);
            System.out.println("Sistem: Saldo sekarang Rp" + this.saldo);
            catatLog("Setor tunai berhasil.");
        }
    }

    public void tarikTunai(double nominal, String inputPin) {
        if (!this.pin.equals(inputPin)) { 
            System.out.println("Sistem: Gagal! PIN salah.");
            catatLog("Tarik tunai gagal (PIN salah).");
        } else if (nominal > saldo) {
            System.out.println("Sistem: Gagal! Saldo tidak mencukupi.");
            catatLog("Tarik tunai gagal (Saldo kurang).");
        } else {
            this.saldo -= nominal;
            System.out.println("Sistem: Berhasil tarik tunai Rp" + nominal); 
            System.out.println(this.saldo);
            catatLog("Tarik tunai berhasil.");
        }
    }

    private void catatLog(String pesan) { 
        System.out.println("[LOG]: " + pesan);
    }
}