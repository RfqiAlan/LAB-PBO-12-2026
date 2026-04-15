import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Masukkan nama cook 1: "); //input orang 1
        String name1 = input.nextLine();

        System.out.print("Masukkan skill cook 1(1-10): ");
        int skill1 = input.nextInt();
        input.nextLine(); // buang enter

        System.out.print("Masukkan nama resep cook 1: ");
        String recipeName1 = input.nextLine();

        System.out.print("Masukkan taste resep cook 1(1-10): ");
        int taste1 = input.nextInt();
        input.nextLine();


        System.out.print("\nMasukkan nama cook 2: "); //input orang 2
        String name2 = input.nextLine();

        System.out.print("Masukkan skill cook 2(1-10): ");
        int skill2 = input.nextInt();
        input.nextLine();

        System.out.print("Masukkan nama resep cook 2: ");
        String recipeName2 = input.nextLine();

        System.out.print("Masukkan taste resep cook 2(1-10): ");
        int taste2 = input.nextInt();


        Recipe r1 = new Recipe(recipeName1, taste1); //buat objek yang diisi inputan lalu akan di eksekusi di class recipe dan disimpan di masing" atrubute
        Recipe r2 = new Recipe(recipeName2, taste2);

        Cook c1 = new Cook(name1, skill1, r1);
        Cook c2 = new Cook(name2, skill2, r2);

        System.out.println("\n=== HASIL ==="); //menjalankan / menampilkan output
        c1.cook();
        c2.cook();

        c1.cookingContest(c2);

    }
}