import java.util.Scanner; 

public class Tuprak_2 { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 

        System.out.print("Input tanggal (dd-mm-yy): "); 
        String input = sc.nextLine(); 

        String[] bagian = input.split("-"); 

        int hari = Integer.parseInt(bagian[0]); 
        int bulan = Integer.parseInt(bagian[1]); 
        int tahun = Integer.parseInt(bagian[2]); 

        String[] namaBulan = { 
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        if (tahun <= 25) {
            tahun = 2000 + tahun;
        } else {
            tahun = 1900 + tahun;
        }

        System.out.println("Output: " + hari + " " + namaBulan[bulan - 1] + " " + tahun); 
    }
}