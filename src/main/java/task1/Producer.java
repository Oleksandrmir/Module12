package task1;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<Integer> queue;
    Integer seconds = 1;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(seconds);
            System.out.println(seconds + " seconds");
            seconds++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

