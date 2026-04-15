import java.util.Scanner;

public class soal1baru {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        
        String kalimat = scanner.nextLine();
        String[] kata = kalimat.split(" "); 

        String hasil = "";

        for (int i = 0; i < kata.length; i++) { 
            String sisanya = kata[i].substring(1); 
            String hurufPertama = kata[i].substring(0,1).toUpperCase();
            hasil += hurufPertama + sisanya + " ";
        }

        System.out.println(hasil.trim()); 
    }
}