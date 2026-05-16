import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    List<abstractLibraryitem> items = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    LibraryLogger logger = new LibraryLogger();

    public String addItem(abstractLibraryitem item) {
        for (abstractLibraryitem existing : items) {
            if (existing.getItemId() == item.getItemId()) {
                throw new IllegalArgumentException(
                    "Item dengan ID " + item.getItemId() + " sudah ada.");
            }
        }
        items.add(item);
        return "Item berhasil ditambahkan: " + item.getDescription();
    }

    public String addMember(Member member) {
        for (Member existing : members) {
            if (existing.getMemberId() == member.getMemberId()) {
                throw new IllegalArgumentException(
                    "Member dengan ID " + member.getMemberId() + " sudah ada.");
            }
        }
        members.add(member);
        return "Member berhasil ditambahkan: " + member.getName();
    }

    public Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) return m;
        }
        throw new NoSuchElementException("Member dengan ID " + id + " tidak ditemukan.");
    }

    public abstractLibraryitem findItemById(int id) {
        for (abstractLibraryitem item : items) {
            if (item.getItemId() == id) return item;
        }
        throw new NoSuchElementException("Item dengan ID " + id + " tidak ditemukan.");
    }

    public String borrowItem(int memberId, int itemId, int days) {
        Member member = findMemberById(memberId);
        abstractLibraryitem item = findItemById(itemId);
        String result = member.borrow(item, days);
        logger.logBorrow(item, member.getName());
        return result;
    }

    public String returnItem(int memberId, int itemId, int daysLate) {
        Member member = findMemberById(memberId);
        abstractLibraryitem item = findItemById(itemId);
        String result = member.returnItem(item, daysLate);
        logger.logReturn(item, member.getName());
        return result;
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) return "Belum ada item di perpustakaan.";
        StringBuilder sb = new StringBuilder();

        int noWidth   = 4;
        int descWidth = 52;
        int statWidth = 10;
        String border = "+" + "-".repeat(noWidth) + "+" + "-".repeat(descWidth) + "+" + "-".repeat(statWidth) + "+";

        sb.append(border).append("\n");
        sb.append(String.format("| %-" + (noWidth-2)  + "s | %-" + (descWidth-2)  + "s | %-" + (statWidth-2) + "s |%n",
                "No", "Deskripsi Item", "Status"));
        sb.append(border).append("\n");

        int no = 1;
        for (abstractLibraryitem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-" + (noWidth-2)  + "d | %-" + (descWidth-2)  + "s | %-" + (statWidth-2) + "s |%n",
                    no++, item.getDescription(), status));
        }
        sb.append(border).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return logger.getLogs();
    }
}