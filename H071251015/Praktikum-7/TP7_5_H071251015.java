import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainGudang {

    public static void main(String[] args) {

        Gudang gudang = new Gudang(10);

        ExecutorService executor = //Ini adalah fitur Java untuk mengelola thread., ibaratnya dia itu manager pekerja
                Executors.newFixedThreadPool(5); //Membuat thread pool isi 5 thread.

                
        executor.execute(new Pemasok(gudang));
        executor.execute(new Pemasok(gudang));
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));

        // monitoring
        Monitoring monitoring = new Monitoring(gudang);
        monitoring.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdownNow();
        monitoring.interrupt();

        try {
            executor.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSistem gudang selesai.");
    }
} 
