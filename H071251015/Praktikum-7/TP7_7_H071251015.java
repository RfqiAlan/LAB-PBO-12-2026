import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchEngineCore {

public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(8);

        ConcurrentHashMap<String, Integer> hasil =
                new ConcurrentHashMap<>();

        ConcurrentHashMap<String, String> threadMap =
                new ConcurrentHashMap<>();

        ConcurrentHashMap<String, Long> durasiMap =
                new ConcurrentHashMap<>();

        String[] dokumen = {
                "Dokumen_A.txt",
                "Dokumen_B.txt",
                "Dokumen_C.txt",
                "Dokumen_D.txt",
                "Dokumen_E.txt",
                "Dokumen_F.txt",
                "Dokumen_G.txt",
                "Dokumen_H.txt",
                "Dokumen_I.txt",
                "Dokumen_J.txt"
        };

        CountDownLatch latch =
                new CountDownLatch(dokumen.length);

        DataProcessor processor = new DataProcessor();

        for (String doc : dokumen) {

        executor.execute(() -> {

                long start = System.currentTimeMillis();

                try {

                int jumlahKata =
                        processor.process(doc);

                long end =
                        System.currentTimeMillis();

                hasil.put(doc, jumlahKata);

                threadMap.put(doc,Thread.currentThread().getName());

                durasiMap.put(doc, end - start);

                    // Progress realtime
                System.out.println(
                        "[" +
                        Thread.currentThread().getName()
                        + "] selesai memproses "
                        + doc
                        + " (" + jumlahKata
                        + " kata)");

                } catch (InterruptedException e) {

                e.printStackTrace();

                } finally {

                latch.countDown();
                }
        });
        }

        try {

        latch.await();

        } catch (InterruptedException e) {

        e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("\n============================== HASIL AKHIR ===============================");

        int totalKata = 0;
        long totalDurasi = 0;

        // Header tabel
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf(
                "%-18s %-20s %-15s %-15s\n",
                "Nama Dokumen",
                "Thread",
                "Jumlah Kata",
                "Durasi");
        System.out.println("--------------------------------------------------------------------------");

        // Isi tabel
        for (String doc : dokumen) {

        int kata = hasil.get(doc);

        long durasi =
                durasiMap.get(doc);

        totalKata += kata;

        totalDurasi += durasi;

        System.out.printf(
                "%-18s %-20s %-15d %-10d ms\n",
                doc,
                threadMap.get(doc),
                kata,
                durasi);
        }

        System.out.println("--------------------------------------------------------------------------");

        // Statistik akhir
        double rataRata =
                (double) totalDurasi / dokumen.length;

        System.out.println("Total Kata Keseluruhan : " + totalKata);

        System.out.printf(
                "Rata-rata Waktu Proses : %.2f ms\n",
                rataRata);

        System.out.println("==========================================================================");
}
}