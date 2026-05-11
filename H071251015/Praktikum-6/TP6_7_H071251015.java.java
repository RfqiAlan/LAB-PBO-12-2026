import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Masukkan angka yang valid.\n");
                continue;
            }
            switch (choice) {
                case 1: tambahItem();               break;
                case 2: tambahAnggota();            break;
                case 3: pinjamItem();               break;
                case 4: kembalikanItem();           break;
                case 5: lihatStatus();              break;
                case 6: lihatLog();                 break;
                case 7: lihatItemDipinjamAnggota(); break;
                case 8:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    running = false;
                    break;
                default:
                    System.out.println("[ERROR] Pilihan tidak valid.\n");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    private static void tambahItem() {
        System.out.println("\n-- Tambah Item --");
        System.out.println("Jenis item: 1. Buku  2. DVD");
        System.out.print("Pilih jenis: ");
        String jenis = scanner.nextLine().trim();

        System.out.print("ID Item: ");
        int id;
        try { id = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("[ERROR] ID harus angka."); return; }

        System.out.print("Judul: ");
        String title = scanner.nextLine().trim();

        try {
            if (jenis.equals("1")) {
                System.out.print("Pengarang: ");
                String author = scanner.nextLine().trim();
                System.out.println(library.addItem(new Book(title, id, author)));
            } else if (jenis.equals("2")) {
                System.out.print("Durasi (menit): ");
                int duration;
                try { duration = Integer.parseInt(scanner.nextLine().trim()); }
                catch (NumberFormatException e) { System.out.println("[ERROR] Durasi harus angka."); return; }
                System.out.println(library.addItem(new DVD(title, id, duration)));
            } else {
                System.out.println("[ERROR] Jenis tidak valid.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static void tambahAnggota() {
        System.out.println("\n-- Tambah Anggota --");
        System.out.print("ID Anggota: ");
        int id;
        try { id = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("[ERROR] ID harus angka."); return; }

        System.out.print("Nama: ");
        String name = scanner.nextLine().trim();

        try {
            System.out.println(library.addMember(new Member(name, id)));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static void pinjamItem() {
        System.out.println("\n-- Pinjam Item --");
        System.out.print("ID Anggota: ");
        int memberId;
        try { memberId = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("[ERROR] ID harus angka."); return; }

        System.out.print("ID Item: ");
        int itemId;
        try { itemId = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("[ERROR] ID harus angka."); return; }

        System.out.print("Jumlah hari peminjaman: ");
        int days;
        try { days = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("[ERROR] Hari harus angka."); return; }

        try {
            System.out.println(library.borrowItem(memberId, itemId, days));
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static void kembalikanItem() {
        System.out.println("\n-- Kembalikan Item --");
        System.out.print("ID Anggota: ");
        int memberId;
        try { memberId = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("[ERROR] ID harus angka."); return; }

        System.out.print("ID Item: ");
        int itemId;
        try { itemId = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("[ERROR] ID harus angka."); return; }

        System.out.print("Keterlambatan (hari, 0 jika tidak terlambat): ");
        int daysLate;
        try { daysLate = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("[ERROR] Hari harus angka."); return; }

        try {
            System.out.println(library.returnItem(memberId, itemId, daysLate));
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static void lihatStatus() {
        System.out.println("\n-- Status Perpustakaan --");
        System.out.print(library.getLibraryStatus());
    }

    private static void lihatLog() {
        System.out.println("\n-- Log Aktivitas --");
        System.out.print(library);
    }

    private static void lihatItemDipinjamAnggota() {
        System.out.println("\n-- Item yang Dipinjam Anggota --");
        System.out.print("ID Anggota: ");
        int memberId;
        try { memberId = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("[ERROR] ID harus angka."); return; }

        try {
            Member member = library.findMemberById(memberId);
            System.out.println("Daftar pinjaman anggota: " + member.getName()
                    + " (ID: " + member.getMemberId() + ")");
            member.getBorrowedItems();
        } catch (NoSuchElementException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}