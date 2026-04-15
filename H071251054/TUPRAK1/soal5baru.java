import java.util.Scanner;

public class soal5baru {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] nums = {
            {1, 2, 3},  
            {4, 5, 6},  
            {7, 8, 9}   
        };

        System.out.print("Masukkan angka yang dicari: ");
        int cari = scanner.nextInt();

        try { 
            boolean ketemu = false; 

            for (int i = 0; i < nums.length; i++) {  
                for (int j = 0; j < nums[i].length; j++) {  

                    if (nums[i][j] == cari) { 

                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        ketemu = true;
                        break; 
                    }
                }

                if (ketemu) break; 
            }

            if (!ketemu) {
                System.out.println("Angka tidak ditemukan");
            }

        } catch (Exception e) {
            System.out.println("Terjadi error");
        }

        scanner.close();
    }
}