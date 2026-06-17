import java.util.Random;

public class Pemasok implements Runnable { //implementasi runnable artinya class ini bisa di jalankan sebagai thread

    private final Gudang gudang;
    private final Random random = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {

        try {

            while (!Thread.currentThread().isInterrupted()) {

                int jumlah = random.nextInt(5) + 1;

                gudang.tambahStok(jumlah);

                Thread.sleep((random.nextInt(2) + 1) * 1000);
            }

        } catch (InterruptedException e) {

            System.out.println(
                    Thread.currentThread().getName()
                    + " berhenti.");
        }
    }
} 