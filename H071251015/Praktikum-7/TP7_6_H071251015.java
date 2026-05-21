import java.util.Random;

public class DataProcessor {

    public int process(String fileName)
            throws InterruptedException {

        Random random = new Random();

        int delay = random.nextInt(1501) + 500;

        Thread.sleep(delay);

        return random.nextInt(900) + 100;
    }
}
