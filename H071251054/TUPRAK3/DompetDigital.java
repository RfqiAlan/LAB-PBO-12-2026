public class DompetDigital {

    private String pin;
    private double saldo;

    protected String idNasabah;
    protected String namaNasabah;

    String statusAkun; 

    public DompetDigital(String idNasabah, String namaNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.namaNasabah = namaNasabah;
        this.pin = pin;

        this.saldo = 0;
        this.statusAkun = "Aktif";

        catatLog("Akun baru berhasil dibuat untuk: " + namaNasabah);
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setPin(String pinLama, String pinBaru) {

        if (!this.pin.equals(pinLama)) {

            System.out.println("[GAGAL] PIN lama salah!");
            catatLog("Ganti PIN gagal - PIN lama salah.");

        } else if (pinBaru.length() != 6) {

            System.out.println("[GAGAL] PIN baru harus 6 karakter!");
            catatLog("Ganti PIN gagal - panjang PIN tidak valid.");

        } else {

            this.pin = pinBaru;

            System.out.println("[BERHASIL] PIN berhasil diubah.");
            catatLog("PIN berhasil diubah.");

        }
    }

    public void setorTunai(double jumlah) {

        if (jumlah <= 0) {

            System.out.println("[GAGAL] Nominal setor tidak valid!");
            catatLog("Setor gagal - nominal: " + jumlah);

        } else {

            saldo += jumlah;

            System.out.println("[BERHASIL] Setor Rp" + jumlah + " berhasil.");
            catatLog("Setor berhasil. Saldo sekarang: Rp" + saldo);

        }
    }

    public void tarikTunai(String pinInput, double jumlah) {

        if (!this.pin.equals(pinInput)) {

            System.out.println("[GAGAL] PIN salah!");
            catatLog("Tarik tunai gagal - PIN salah.");

        } else if (jumlah > saldo) {

            System.out.println("[GAGAL] Saldo tidak cukup!");
            catatLog("Tarik tunai gagal - saldo kurang.");

        } else {

            saldo -= jumlah;

            System.out.println("[BERHASIL] Tarik Rp" + jumlah + " berhasil.");
            catatLog("Tarik berhasil. Saldo sekarang: Rp" + saldo);

        }
    }

    private void catatLog(String pesan) {
        System.out.println("[LOG] " + pesan);
    }

}