class Camera extends Product {
    int resolution;
    String lensType;

    Camera(String brand, int seriesNumber, double price, int resolution, String lensType) {
        super(brand, seriesNumber, price); 
        this.resolution = resolution;
        this.lensType = lensType;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution + "MP");
        System.out.println("Lens Type: " + lensType);
    }
}