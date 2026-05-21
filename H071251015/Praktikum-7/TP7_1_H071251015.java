public class Gudang{

    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("Gudang penuh! Pemasok menunggu...");
            wait();
        }
        stok += jumlah;
        System.out.println(Thread.currentThread().getName() + " menambah " + jumlah + " barang | Stok sekarang: " + stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println("Stok kosong! Kurir menunggu...");
            wait();
        }
        stok -= jumlah;
        System.out.println(Thread.currentThread().getName() + " mengambil " + jumlah + " barang | Stok sekarang: " + stok);
        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}