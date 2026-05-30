public class Gudang {
    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException {
        while(stok + jumlah > kapasitasMaksimal) {
            wait();
        }
        stok += jumlah;
        System.out.println("[Pemasok] + " + jumlah + " barang. Stok : " + stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while(stok < jumlah) {
            wait();
        }
        stok -= jumlah;
        System.out.println("[Kurir] - " + jumlah + " barang. Stok : " + stok);
        notifyAll();
    }

    public synchronized void tampilkanStatus() {
        int persentase = (stok * 100) / 100;
        int barlength = 20;
        int filled = (persentase * barlength) / 100;
        StringBuilder bar = new StringBuilder();

        for(int i = 0; i < filled; i++) {
            bar.append("#");
        }

        for(int i = filled; i < barlength; i++) {
            bar.append("-");
        }

        System.out.println("Status Gudang :  [" + bar + "] " + persentase + "% (" + stok + "/" + kapasitasMaksimal + ")\n");
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getkapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}
