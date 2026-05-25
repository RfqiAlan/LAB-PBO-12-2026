import java.util.Scanner;

public class TP1_no4_H071251011 {
    public static int faktorial (int n) {
        if (n == 0 ) {
            return 1;
        } else {
            return n * faktorial(n-1);
        }
    }    
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        System.out.print("Masukkan bilangan n : ");
        int n = a.nextInt();

        int hasil = faktorial(n);
        System.out.println("Output : " + hasil);

        a.close();
    }
}

