package task1;

import java.util.concurrent.*;

public class Task1Test {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        executor.scheduleAtFixedRate(new Producer(queue), 1, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new Consumer(queue), 0, 100, TimeUnit.MILLISECONDS);
    }
}