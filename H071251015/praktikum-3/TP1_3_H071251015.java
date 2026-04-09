import java.util.Scanner; 

public class Tuprak_3{ 
    public static void main(String[] args) { 

        Scanner input = new Scanner(System.in); 
        System.out.print("Masukkan password: "); 
        String password = input.nextLine(); 

        boolean hurufBesar = false;  //deklarasi
        boolean hurufKecil = false;
        boolean angka = false;

        if(password.length() >= 8){ 

            for(char c : password.toCharArray()){ 
                if(Character.isUpperCase(c)) hurufBesar = true; 
                else if(Character.isLowerCase(c)) hurufKecil = true; 
                else if(Character.isDigit(c)) angka = true; 
            }

            if(hurufBesar && hurufKecil && angka){ 
                System.out.println("Password valid"); 
            }else{
                System.out.println("Password tidak valid"); 
            }

        }else{
            System.out.println("Password tidak valid"); 
        }
    }
}