class Smartphone extends Product {
    double screenSize;
    int storage;

    Smartphone(String brand, int seriesNumber, double price, double screenSize, int storage) {
        super(brand, seriesNumber, price);
        this.screenSize = screenSize;
        this.storage = storage;
    }

@Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inch");
        System.out.println("Storage: " + storage + "GB");
    }
}