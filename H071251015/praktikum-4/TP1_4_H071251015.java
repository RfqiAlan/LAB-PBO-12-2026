import java.util.Scanner; 

public class Tuprak_4 { 

    public static int faktorial(int n){ 
        if(n == 0 || n == 1){   //method rekursif
            return 1;
        }else{
            return n * faktorial(n - 1); 
        }
    }

    public static void main(String[] args) { 

        Scanner input = new Scanner(System.in); 

        System.out.print("Input: ");
        int n = input.nextInt();

        System.out.println("Output: " + faktorial(n)); 
    }
}