import java.util.Scanner;

public class TP1_no3_H071251011 {
    public static boolean cekPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(c)) {
                adaAngka = true;
            }
        }

        return adaHurufBesar && adaHurufKecil && adaAngka;
    }

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        System.out.print("Masukkan password : ");
        String input = a.nextLine();

        if (cekPassword(input)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        a.close();
    }
}
