class Counter {
    private int count = 0;

    // The 'synchronized' keyword prevents thread interference and race conditions
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Day 24: Testing Thread Synchronization ---");

        Counter counter = new Counter();

        // Thread 1 increments 1000 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Thread 2 increments 1000 times
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Start both threads concurrently
        t1.start();
        t2.start();

        // Wait for both threads to finish execution
        t1.join();
        t2.join();

        // Output will reliably be 2000 because of synchronization!
        System.out.println(" Final Count (Expected 2000): " + counter.getCount());
    }
}