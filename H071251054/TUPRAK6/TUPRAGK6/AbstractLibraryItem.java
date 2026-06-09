public abstract class AbstractLibraryItem {
    private String title;
    private int itemId;
    private boolean isBorrowed;

    public AbstractLibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    // abstract methods
    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    // concrete method
    public String returnItem() {
        this.isBorrowed = false;
        return title + " dikembalikan";
    }

    public String getTitle() {
        return title;
    }

    public int getItemId() {
        return itemId;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
