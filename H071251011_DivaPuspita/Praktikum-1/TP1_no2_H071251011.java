import java.util.Scanner;

public class TP1_no2_H071251011 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = a.nextLine();

        String[] bagian = input.split("-");
        if (bagian.length != 3) {
            System.out.println("Format salah! Gunakan dd-mm-yy");
            return;
        }

        //mengubah string yg di masukkan di inputan menjadi int 
        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);

        if (tahun >= 0 && tahun <= 50) {
            tahun += 2000;   
        } else {
            tahun += 1900;   
        }

        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        if (bulan < 1 || bulan > 12) {
            System.out.println("BULAN HANYA MULAI DARI 1-12 OIII"); 
        } else {
            System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahun);
        }
        
        a.close();
    }
}


    
