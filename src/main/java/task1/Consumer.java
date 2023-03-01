package task1;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        if (queue.size() >= 5) {
            System.out.println("5 seconds have passed");
            while (!queue.isEmpty()) {
                queue.poll();
            }
        }
    }
}
