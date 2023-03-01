package task2;

import java.util.concurrent.BlockingQueue;

public class BuzzProducer implements Runnable {
    BlockingQueue<String> queue;
    private int n;
    private boolean updated = false;
    private boolean interrupted = false;

    public BuzzProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void setN(int n) {
        this.n = n;
        updated = true;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }

    public boolean isUpdated() {
        return updated;
    }

    @Override
    public void run() {
        while (!interrupted) {
            try {
                if (updated) {
                    updated = false;
                    if (!(n % 3 == 0) && (n % 5 == 0)) {
                        queue.put("buzz");
                    }
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
