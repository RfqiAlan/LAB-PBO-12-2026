import java.util.Random;

public class Kurir implements Runnable {
    private final Gudang gudang;
    private final Random rand = new Random();

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                int jumlah = rand.nextInt(3) + 1;
                gudang.ambilStok(jumlah);
                Thread.sleep(rand.nextInt(1000) + 2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}