import java.util.Random;

public class Kurir implements Runnable { //implementasi runnable artinya class ini bisa dijalankan sebagai thread.

    private final Gudang gudang;
    private final Random random = new Random();

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(3) + 1;
                gudang.ambilStok(jumlah);
                Thread.sleep((random.nextInt(2) + 2) * 1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " berhenti.");
        }
    }
} 