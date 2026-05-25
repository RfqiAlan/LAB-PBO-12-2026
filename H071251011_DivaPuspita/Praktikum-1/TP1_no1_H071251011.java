import java.util.Scanner;

public class TP1_no1_H071251011 {
    public static String capitalizeWords(String input) {  
        String[] film = input.toLowerCase().split("\\s+");
        String hasil = "";

        for (int i = 0; i < film.length; i++) {
            if (film[i].length() > 0) {
                hasil += Character.toUpperCase(film[i].charAt(0))
                    + film[i].substring(1) + " ";
            }
        }
        return hasil.trim();
    }
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan Judul Film : ");
        String judul = a.nextLine();

        System.out.println(capitalizeWords(judul));
        a.close();
    }
} 
