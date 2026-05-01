public class main {
    public static void main(String[] args) {
        DompetDigital akun = new DompetDigital("DIV123", "090807", 500000);

        System.out.println("\n===Informasi akun===");
        System.out.println("ID Nasabah : " + akun.getidNasabah());
        System.out.println("Mode Operasi : " + akun.getmodeOperasi());

        System.out.println("\n===Mengubah idNasabah===");
        akun.setidNasabah("000000", "DIV456");

        System.out.println("\n===Mengubah idNasabah===");
        akun.setidNasabah("DIV123", "DIV456");

        System.out.println("\n===Menguji kevalidan input PIN lama===");
        akun.setPin("000000", "060504");

        System.out.println("\n===Menguji PIN lama asli yang berhasil di ubah ke PIN baru===");
        akun.setPin("090807", "060504");

        System.err.println("\n===Menguji kevalidan nominal yang di setor tunai===");
        akun.setorTunai(500000);

        System.out.println("\n===Menguji nominal angka yang dimasukkan tidak boleh (-)===");
        akun.setorTunai(-100000);

        System.out.println("\n===Menguji kevalidan PIN untuk tarik tunai===");
        akun.tarikTunai(50000, "090807");

        System.out.println("\n===Menguji bahwa tarik tunai berhasil karena pin yang dimasukkan valid===");
        akun.tarikTunai(100000, "060504");

        System.out.println("\n===Saldo akhir===");
        System.out.println("Saldo akhir : " + akun.getSaldo()); 
        // %.0f\n untuk decimal format (klo perlu aja)

        System.out.println("\n===Ubah mode operasi ke Maintenance===");
        akun.setmodeOperasi("Maintenance");
        System.out.println("Mode Operasi sekarang : " + akun.getmodeOperasi());

        System.out.println("\n===Coba setor tunai saat Maintenance===");
        akun.setorTunai(200000); // otomatis ditolak krn sistem sedang dalam maintenance(Perawatan)
    }
}
