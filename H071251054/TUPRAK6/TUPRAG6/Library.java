import java.util.ArrayList;

public class Library {

    ArrayList<LibraryItem> items = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        // Pengecekan agar ID Item (Buku/DVD) tidak boleh sama dan tidak tertimpa
        if (findItemById(item.getItemId()) != null) {
            throw new IllegalArgumentException(
                "Gagal! Item dengan ID " + item.getItemId() + " sudah ada di perpustakaan.");
        }
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public String addMember(Member member) {
        // Pengecekan agar ID Member tidak boleh sama dan tidak tertimpa
        if (findMemberById(member.getMemberId()) != null) {
            throw new IllegalArgumentException(
                "Gagal! Member dengan ID " + member.getMemberId() + " sudah terdaftar.");
        }
        members.add(member);
        return "Member " + member.getName() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) return item;
        }
        return null;
    }

    public Member findMemberById(int memberId) {
        for (Member m : members) {
            if (m.getMemberId() == memberId) return m;
        }
        return null;
    }

    private Member getMemberById(int memberId) {
        Member member = findMemberById(memberId);
        if (member == null) {
            throw new java.util.NoSuchElementException("Member dengan ID " + memberId + " tidak ditemukan!");
        }
        return member;
    }

    public String borrowItem(int memberId, int itemId, int days) {
        Member member = getMemberById(memberId);

        LibraryItem item = findItemById(itemId);
        if (item == null) throw new IllegalArgumentException("Item dengan ID " + itemId + " tidak ditemukan!");

        String result = member.borrow(item, days);

        String itemType = (item instanceof Book) ? "Buku" : "DVD";
        logger.logBorrow(itemType, item.getTitle(), member.getName());

        return result;
    }

    public String returnItem(int memberId, int itemId, int daysLate) {
        Member member = getMemberById(memberId);

        LibraryItem item = findItemById(itemId);
        if (item == null) throw new IllegalArgumentException("Item dengan ID " + itemId + " tidak ditemukan!");

        String result = member.returnItem(item, daysLate);
        logger.logReturn(item.getTitle(), member.getName());

        return result;
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) return "Tidak ada item di perpustakaan.";

        String line = "+------+------------------------------+------------+";
        StringBuilder sb = new StringBuilder();
        sb.append(line).append("\n");
        sb.append(String.format("| %-4s | %-28s | %-10s |%n", "ID", "Judul", "Status"));
        sb.append(line).append("\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-4d | %-28s | %-10s |%n",
                item.getItemId(), item.getTitle(), status));
        }
        sb.append(line);
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }
}