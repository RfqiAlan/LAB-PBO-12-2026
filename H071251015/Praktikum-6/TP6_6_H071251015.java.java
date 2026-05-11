import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<abstractLibraryitem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(abstractLibraryitem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item \"" + item.getTitle() + "\" tidak tersedia (sudah dipinjam).");
        }
        item.borrowItem(days);
        borrowedItems.add(item);
        return "Item \"" + item.getTitle() + "\" berhasil dipinjam selama " + days + " hari.";
    }

    public String returnItem(abstractLibraryitem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            throw new IllegalStateException("Item \"" + item.getTitle() + "\" tidak ada dalam daftar pinjaman Anda.");
        }
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return String.format("Item \"%s\" berhasil dikembalikan. Denda keterlambatan: Rp %,.0f", item.getTitle(), fine);
    }

    /** Tampilkan daftar pinjaman + status item */
    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang sedang dipinjam.");
            return;
        }

        int noW     = 4;
        int idW     = 6;
        int titleW  = 30;
        int typeW   = 8;
        int statusW = 10;

        String border = "+"
            + "-".repeat(noW)     + "+"
            + "-".repeat(idW)     + "+"
            + "-".repeat(titleW)  + "+"
            + "-".repeat(typeW)   + "+"
            + "-".repeat(statusW) + "+";

        System.out.println(border);
        System.out.printf("| %-" + (noW-2)    + "s | %-" + (idW-2)    + "s | %-" + (titleW-2)
                + "s | %-" + (typeW-2) + "s | %-" + (statusW-2) + "s |%n",
                "No", "ID", "Judul", "Tipe", "Status");
        System.out.println(border);

        int no = 1;
        for (abstractLibraryitem item : borrowedItems) {
            String tipe   = (item instanceof Book) ? "Buku" : "DVD";
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            System.out.printf("| %-" + (noW-2)    + "d | %-" + (idW-2)    + "d | %-" + (titleW-2)
                    + "s | %-" + (typeW-2) + "s | %-" + (statusW-2) + "s |%n",
                    no++, item.getItemId(), item.getTitle(), tipe, status);
        }
        System.out.println(border);
    }

    public List<abstractLibraryitem> getBorrowedItemsList() { return borrowedItems; }
    public String getName()   { return name; }
    public int getMemberId()  { return memberId; }
}