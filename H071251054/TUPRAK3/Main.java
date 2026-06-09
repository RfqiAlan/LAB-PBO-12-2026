import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.println("=== BUAT AKUN DOMPET DIGITAL ===");

        System.out.print("ID Nasabah : ");
        String id = input.nextLine();

        System.out.print("Nama Nasabah : ");
        String nama = input.nextLine();

        System.out.print("PIN (6 digit) : ");
        String pin = input.nextLine();

        DompetDigital akun = new DompetDigital(id, nama, pin);

        int pilihan;

        do {

            System.out.println("\n===== MENU DOMPET DIGITAL =====");
            System.out.println("1. Tampilkan Informasi Akun");
            System.out.println("2. Ubah PIN");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Tarik Tunai");
            System.out.println("5. Tampilkan Saldo");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    System.out.println("\n=== INFORMASI AKUN ===");
                    System.out.println("ID Nasabah   : " + akun.getIdNasabah());
                    System.out.println("Nama Nasabah : " + akun.getNamaNasabah());
                    break;

                case 2:
                    System.out.println("\n=== UBAH PIN ===");

                    System.out.print("Masukkan PIN lama: ");
                    String pinLama = input.nextLine();

                    System.out.print("Masukkan PIN baru: ");
                    String pinBaru = input.nextLine();

                    akun.setPin(pinLama, pinBaru);
                    break;

                case 3:
                    System.out.println("\n=== SETOR TUNAI ===");

                    System.out.print("Masukkan nominal setor: ");
                    double setor = input.nextDouble();

                    akun.setorTunai(setor);
                    break;

                case 4:
                    System.out.println("\n=== TARIK TUNAI ===");

                    input.nextLine();

                    System.out.print("Masukkan PIN: ");
                    String pinTarik = input.nextLine();

                    System.out.print("Masukkan nominal tarik: ");
                    double tarik = input.nextDouble();

                    akun.tarikTunai(pinTarik, tarik);
                    break;

                case 5:
                    System.out.println("\nSaldo saat ini: Rp" + akun.getSaldo());
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");

            }

        } while (pilihan != 0);

        input.close();
    }
}