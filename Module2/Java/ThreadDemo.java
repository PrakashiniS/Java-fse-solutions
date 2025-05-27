public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: Count " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.err.println("Thread 1 interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: Count " + i);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    System.err.println("Thread 2 interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted");
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread completed");
    }
}