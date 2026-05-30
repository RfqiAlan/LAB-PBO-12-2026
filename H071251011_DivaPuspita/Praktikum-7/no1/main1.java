import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class main1 {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(20);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new Pemasok(gudang));
        executor.execute(new Pemasok(gudang));
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));

        Thread monitor = new Thread(new Monitoring(gudang));
        monitor.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println("Thread terganggu : " + e.getMessage());
        }
    
        executor.shutdownNow();
        monitor.interrupt();

        try {
            executor.awaitTermination(15, TimeUnit.SECONDS);
            System.out.println("Sistem Gudang berhenti dengan aman.");
        } catch (InterruptedException e) {
            System.out.println("Thread terganggu : " + e.getMessage());
        }
    }
}
