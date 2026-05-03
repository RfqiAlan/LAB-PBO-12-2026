public class main {
    public static void main(String[] args) { 
        DompetDigital dompet = new DompetDigital("OSH41297", "OHSEHUN", "123456");

        System.out.println("\n--- INFORMASI AKUN ---");
        System.out.println("ID Nasabah   : " + dompet.idNasabah); 
        System.out.println("Nama Pemilik : " + dompet.getNamaNasabah());
        System.out.println("-----------------------");
        // dompet.setpin ("nita888");
        System.out.println(dompet.getpin());

        System.out.println("\n---Uji Coba: Ubah PIN (PIN lama salah)---");
        dompet.setPin("1123456", "654321");

        System.out.println("\n---Uji Coba: Ubah PIN (Benar)---");
        dompet.setPin("123456", "111222");
        System.out.println(dompet.getpin());
        System.out.println("\n---Uji Coba: Setor Tunai Valid---");
        dompet.setorTunai(500000);

        System.out.println("\n---Uji Coba: Setor Tunai Tidak Valid (nominal 0)---");
        dompet.setorTunai(0);

        System.out.println("\n---Uji Coba: Tarik Tunai (PIN lama/salah)---");
        dompet.tarikTunai(100000, "123456");

        System.out.println("\n---uji coba: Tarik Tunai (PIN baru/benar)---");
        dompet.tarikTunai(200000, "111222");
        
        System.out.println("\n--- STATUS AKHIR ---");
        System.out.println("Saldo Akhir: " + dompet.getSaldo());
    }
}