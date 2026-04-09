import java.util.Scanner;
public class TP1_no5_H071251011{
    public static void main(String[] args) {
        //ingat! di java indeks sllu dibca dari 0, array 2d itu sm kek matriks ad bar-kol
        int[][]nums = { 
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan angka yang kamu cari: ");

        try {
            int target = a.nextInt();
            boolean found = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "] [" + j + "]");
                        found = true;
                        break;
                    }
                }
                if (found) break; 
            }
            if (!found) {
                System.out.println("Angka " + target + " tidak ditemukan");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid! Harus berupa angka");
        }
        a.close();
    }
}
