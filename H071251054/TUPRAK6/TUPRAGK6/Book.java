public class Book extends AbstractLibraryItem {
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + getTitle() + " oleh " + author + ", ID: " + getItemId();
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed()) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Buku hanya dapat dipinjam maksimal 14 hari.");
        }
        return "Item " + getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }

    public String getAuthor() {
        return author;
    } 
}
