import java.util.Random;

public class DataProcessor {
    public int process(String fileName) throws InterruptedException {
        Random random = new Random();
        int delay = 500 + random.nextInt(1501);
        Thread.sleep(delay);
        return 100 + random.nextInt(900);
    }
}
