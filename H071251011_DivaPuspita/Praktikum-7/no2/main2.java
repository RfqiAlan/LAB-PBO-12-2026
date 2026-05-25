import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> dokumen = Arrays.asList(
            "Dokumen_A.txt", "Dokumen_B.txt", "Dokumen_C.txt",
            "Dokumen_D.txt", "Dokumen_E.txt", "Dokumen_F.txt",
            "Dokumen_G.txt", "Dokumen_H.txt", "Dokumen_I.txt",
            "Dokumen_J.txt"
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);                  
        ConcurrentHashMap<String, Integer> results = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Long> durations = new ConcurrentHashMap<>();
    
        CountDownLatch latch = new CountDownLatch(dokumen.size());
        DataProcessor processor = new DataProcessor();

        long startAll = System.currentTimeMillis();

        for (String doc : dokumen) {
            executor.execute(new DocumentTask(doc, processor, results, durations, latch));
        }

        latch.await();
        executor.shutdown();

        long totalWords = results.values().stream().mapToInt(Integer::intValue).sum();
        double avgDuration = durations.values().stream().mapToLong(Long::longValue).average().orElse(0);

        System.out.println("\n================== Ringkasan Hasil ==================");
        System.out.println("+-----------------+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s | %-15s |\n", "Dokumen", "Thread", "Durasi(ms)");
        System.out.println("+-----------------+-----------------+-----------------+");
    for (String doc : dokumen) {
        System.out.printf("| %-15s | %-15s | %-15d |\n",
            doc,
            "Thread", 
            durations.get(doc));
    }
        System.out.println("+-----------------+-----------------+-----------------+");

        System.out.println("\nTotal kata: " + totalWords);
        System.out.println("Rata-rata durasi: " + avgDuration + " ms");
        System.out.println("Total waktu eksekusi: " + (System.currentTimeMillis() - startAll) + " ms");
    }
}

