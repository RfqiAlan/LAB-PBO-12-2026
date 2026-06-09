import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<AbstractLibraryItem> items; 
    private List<Member> members; 
    private LibraryLogger logger; 

    public Library() { 
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public String addItem(AbstractLibraryItem item) { 
        for (AbstractLibraryItem existingItem : items) { 
            if (existingItem.getItemId() == item.getItemId()) {
                throw new IllegalArgumentException("Item dengan ID " + item.getItemId() + " sudah terdaftar. Gagal menambahkan.");
            }
        }
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public AbstractLibraryItem findItemById(int itemId) {
        for (AbstractLibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public String addMember(Member member) { 
        for (Member existingMember : members) { 
            if (existingMember.getMemberId() == member.getMemberId()) {
                throw new IllegalArgumentException("Anggota dengan ID " + member.getMemberId() + " sudah terdaftar. Gagal menambahkan.");
            }
        }
        members.add(member);
        return "Anggota " + member.getName() + " berhasil ditambahkan";
    }

    public Member findMemberById(int memberId) { 
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        throw new NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan.");
    }

    public String borrowItem(int memberId, int itemId, int days) { 
        Member member = findMemberById(memberId); 
        AbstractLibraryItem item = findItemById(itemId);
        String result = member.borrow(item, days); 

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.logBorrow(timestamp, item.getTitle(), member.getName());

        return result;
    }

    public String returnItem(int memberId, int itemId, int daysLate) {
        Member member = findMemberById(memberId);
        AbstractLibraryItem item = findItemById(itemId);
        String result = member.returnItem(item, daysLate);

        String returnTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.logReturn(item.getTitle(), returnTime); 
        return result;
    }

    public String getLibraryStatus() { 
        if (items.isEmpty()) {
            return "Tidak ada item di perpustakaan.";
        }

        String border = "+------+--------------------------------+----------+";
        String hasil = border + "\n";
        hasil += String.format("| %-4s | %-30s | %-8s |%n", "ID", "Judul", "Status");
        hasil += border + "\n";

        for (AbstractLibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            hasil += String.format("| %-4d | %-30s | %-8s |%n", item.getItemId(), item.getTitle(), status);
        }

        hasil += border;
        return hasil;
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public List<AbstractLibraryItem> getItems() { 
        return items;
    }

    public List<Member> getMembers() { 
        return members;
    }
}