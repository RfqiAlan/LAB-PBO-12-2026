package lat1;

public class coba {
    private double saldo;
    String namaPemilik;

    public coba (double saldo, String namaPemilik) {
        this.saldo = 0;
        this.namaPemilik = namaPemilik;
    } 

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public boolean setor(double jumlah) {
        if(jumlah <= 0) {
            System.out.println("Setor tunai Anda gagal karena nominal tidak cukup");
            return false;
        } else {
            System.out.println("Setor tunai Anda berhasil : " + jumlah);
        }
        saldo += jumlah;
        return true;
    }

    public boolean tarik(double jumlah) {
        if(jumlah <= 0) {
            System.out.println("Tarik tunai Anda gagal karena nominal tidak cukup");
            return false;
        } else {
            System.out.println("Tarik tunai Anda berhasil : " + jumlah);
        }
        saldo -= jumlah;
        return true;
    }
}
