import java.util.Scanner; 

public class Tuprak_5{  
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 

        int[][] nums = {
            {1, 2, 3}, 
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(nums[0][0]);
        try { 
            System.out.print("Masukkan angka: "); 
            int cari = input.nextInt();

            boolean ketemu = false; 

            for (int i = 0; i < nums.length; i++) { 
                for (int j = 0; j < nums[i].length; j++) { 
                    if (nums[i][j] == cari) { 
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]"); 
                        ketemu = true;
                        break; 
                    }
                }
                if (ketemu) {
                    break; 
                }
            }

            if (!ketemu) {
                System.out.println("Angka tidak ditemukan"); 
            }

        } catch (Exception e) { 
            System.out.println("Input harus berupa angka!");
        }

        input.close(); 
    }
}