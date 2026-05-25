import java.util.Random;

public class Pemasok implements Runnable {
    private final Gudang gudang;
    private final Random rand = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }
    
    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                int jumlah = rand.nextInt(5) + 1;
                gudang.tambahStok((jumlah));
                Thread.sleep((rand.nextInt(2) + 1) * 1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
} 