import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    tambahItem();
                    break;
                case "2":
                    tambahAnggota();
                    break;
                case "3":
                    pinjamItem();
                    break;
                case "4":
                    kembalikanItem();
                    break;
                case "5":
                    lihatStatusPerpustakaan();
                    break;
                case "6":
                    lihatLogAktivitas();
                    break;
                case "7":
                    lihatItemDipinjamAnggota();
                    break;
                case "8":
                    System.out.println("Terima kasih. Sampai jumpa!");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
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
        System.out.println("--- Tambah Item ---");
        System.out.println("Pilih jenis item:");
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        System.out.print("Pilih: ");
        String jenis = scanner.nextLine().trim();

        try {
            System.out.print("Masukkan ID item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Masukkan judul: ");
            String title = scanner.nextLine().trim();

            if (jenis.equals("1")) {
                System.out.print("Masukkan nama pengarang: ");
                String author = scanner.nextLine().trim();
                Book book = new Book(title, itemId, author);
                System.out.println(library.addItem(book));
            } else if (jenis.equals("2")) {
                System.out.print("Masukkan durasi (menit): ");
                int duration = Integer.parseInt(scanner.nextLine().trim());
                DVD dvd = new DVD(title, itemId, duration);
                System.out.println(library.addItem(dvd));
            } else {
                System.out.println("Jenis item tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan inputan sesuai dengan ketentuan yang benar.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void tambahAnggota() {
        System.out.println("--- Tambah Anggota ---");
        try {
            System.out.print("Masukkan ID anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Masukkan nama anggota: ");
            String name = scanner.nextLine().trim();
            Member member = new Member(name, memberId);
            System.out.println(library.addMember(member));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan inputan sesuai dengan ketentuan yang benar.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void pinjamItem() {
        System.out.println("--- Pinjam Item ---");
        try {
            System.out.print("Masukkan ID anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Masukkan ID item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Masukkan jumlah hari peminjaman: ");
            int days = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(library.borrowItem(memberId, itemId, days));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan inputan sesuai dengan ketentuan yang benar.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void kembalikanItem() {
        System.out.println("--- Kembalikan Item ---");
        try {
            System.out.print("Masukkan ID anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Masukkan ID item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Masukkan jumlah hari keterlambatan: ");
            int daysLate = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(library.returnItem(memberId, itemId, daysLate));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan inputan sesuai dengan ketentuan yang benar.");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void lihatStatusPerpustakaan() {
        System.out.println("--- Status Perpustakaan ---");
        System.out.println(library.getLibraryStatus());
    }

    private static void lihatLogAktivitas() {
        System.out.println("--- Log Aktivitas ---");
        System.out.println(library.getAllLogs());
    }

    private static void lihatItemDipinjamAnggota() {
        System.out.println("--- Item yang Dipinjam Anggota ---");
        try {
            System.out.print("Masukkan ID anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            Member member = library.findMemberById(memberId);
            System.out.println("Item yang dipinjam oleh " + member.getName() + ":");
            member.getBorrowedItems();
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan inputan sesuai dengan ketentuan yang benar.");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}