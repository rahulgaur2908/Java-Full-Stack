// Task 1 implementing Runnable
class DatabaseBackupWorker implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[Thread-DB] Backing up database row " + i + "...");
            try {
                Thread.sleep(500); // Simulating time-consuming task
            } catch (InterruptedException e) {
                System.out.println("DB Task interrupted!");
            }
        }
        System.out.println("[Thread-DB] Backup complete!");
    }
}

public class Threads {
    public static void main(String[] args) {
        System.out.println("--- Day 23: Executing Concurrent Threads ---");

        // 1. Creating a Thread using the Runnable interface
        Thread dbThread = new Thread(new DatabaseBackupWorker());

        // 2. Creating a second Thread using a modern Lambda Expression
        Thread emailThread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(" [Thread-Email] Sending confirmation email " + i + "...");
                try {
                    Thread.sleep(300); // Faster background task
                } catch (InterruptedException e) {
                    System.out.println("Email Task interrupted!");
                }
            }
            System.out.println(" [Thread-Email] All emails dispatched!");
        });

        // 3. Starting both threads simultaneously
        dbThread.start();
        emailThread.start();

        System.out.println(" [Main Thread] Main program continues executing while workers run in background!\n");
    }
}