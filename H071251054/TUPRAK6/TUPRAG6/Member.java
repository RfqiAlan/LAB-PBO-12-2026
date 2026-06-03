import java.util.ArrayList;

public class Member {
    private String name;
    private int memberId;
    private ArrayList<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String borrow(LibraryItem item, int days) {
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " dikembalikan. Denda: Rp " + (long)fine;
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }
}