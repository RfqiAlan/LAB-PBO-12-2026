import java.util.Scanner;

public class soal2baru {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine();
        String[] bagian = input.split("-"); 

        int hari = Integer.parseInt(bagian[0]); 
        int bulan = Integer.parseInt(bagian[1]);
        int tahunPendek = Integer.parseInt(bagian[2]);

        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        String namaBulannya = namaBulan[bulan - 1];
        
        int tahun; 
        if (tahunPendek <= 26) {
            tahun = 2000 + tahunPendek;
        } else {
            tahun = 1900 + tahunPendek;
        }

        System.out.println(hari + " " + namaBulannya + " " + tahun);

        scanner.close();
    }
}