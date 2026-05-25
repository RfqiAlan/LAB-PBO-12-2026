import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class DocumentTask implements Runnable {
    private String docName;
    private DataProcessor processor;
    private ConcurrentHashMap<String, Integer> results;
    private ConcurrentHashMap<String, Long> durations;
    private CountDownLatch latch;

    public DocumentTask(String docName, DataProcessor processor,
                        ConcurrentHashMap<String, Integer> results,
                        ConcurrentHashMap<String, Long> durations,
                        CountDownLatch latch) {
        this.docName = docName;
        this.processor = processor;
        this.results = results;
        this.durations = durations;
        this.latch = latch;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int wordCount = 0;
        try {
            wordCount = processor.process(docName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread terganggu saat memproses " + docName);
        }
        long duration = System.currentTimeMillis() - start;

        results.put(docName, wordCount);
        durations.put(docName, duration);

        System.out.println("[" + Thread.currentThread().getName() + "] "
            + "Selesai memproses " + docName + " (" + wordCount + " kata).");

        latch.countDown();
    }
}
