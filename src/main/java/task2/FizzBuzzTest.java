package task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        NumberProducer numberProducer = new NumberProducer(queue);
        FizzProducer fizzProducer = new FizzProducer(queue);
        BuzzProducer buzzProducer = new BuzzProducer(queue);
        FizzBuzzProducer fizzBuzzProducer = new FizzBuzzProducer(queue);
        Consumer consumer = new Consumer(queue);

        executor.execute(numberProducer);
        executor.execute(fizzProducer);
        executor.execute(buzzProducer);
        executor.execute(fizzBuzzProducer);

        for (int i = 1; i <= 60; i++) {
            numberProducer.setN(i);
            fizzProducer.setN(i);
            buzzProducer.setN(i);
            fizzBuzzProducer.setN(i);

            while (numberProducer.isUpdated() ||
                    (fizzProducer.isUpdated()) ||
                    (buzzProducer.isUpdated()) ||
                    (fizzBuzzProducer.isUpdated())) {
                Thread.sleep(50);
            }

            consumer.consumer();
        }

        numberProducer.setInterrupted(true);
        fizzProducer.setInterrupted(true);
        buzzProducer.setInterrupted(true);
        fizzBuzzProducer.setInterrupted(true);
        executor.shutdown();
    }
}