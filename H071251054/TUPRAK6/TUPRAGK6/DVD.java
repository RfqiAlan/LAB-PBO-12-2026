public class DVD extends AbstractLibraryItem {
    private int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: " + getTitle() + ", durasi " + duration + " menit, ID: " + getItemId();
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed()) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 7) {
            throw new IllegalArgumentException("DVD hanya dapat dipinjam maksimal 7 hari.");
        }
        return "Item " + getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }

    public int getDuration() {
        return duration;
    }
}
