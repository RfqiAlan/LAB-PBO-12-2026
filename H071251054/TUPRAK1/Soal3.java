import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String pass = input.nextLine();

        boolean besar = false; 
        boolean kecil = false;
        boolean angka = false;

        for (int i = 0; i < pass.length(); i++) { 
            char c = pass.charAt(i); 

            if (Character.isUpperCase(c)) besar = true; 
            if (Character.isLowerCase(c)) kecil = true;
            if (Character.isDigit(c)) angka = true;
        }

        if (pass.length() >= 8 && besar && kecil && angka) { 
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
    }
}

