import java.util.Scanner;

public class soal4baru {
    public static int faktorial(int n) { 

        if (n == 1) {
            return 1;
        }
        
        return n * faktorial(n - 1); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        int n = scanner.nextInt();

        int hasil = faktorial(n); 

        System.out.println("Hasil: " + hasil);

        scanner.close();
    }
}