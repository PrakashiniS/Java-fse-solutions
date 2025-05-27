import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadDemo {
    public static void main(String[] args) {
        int numThreads = 100_000;
        System.out.println("Creating " + numThreads + " virtual threads...");

        long startTime = System.nanoTime();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < numThreads; i++) {
                final int threadNum = i;
                executor.submit(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.println("Virtual Thread " + threadNum + " completed");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }

        long endTime = System.nanoTime();
        Duration duration = Duration.ofNanos(endTime - startTime);
        System.out.println("\nAll virtual threads completed in " + duration.toMillis() + " ms");

        System.out.println("\nNow creating " + numThreads + " platform threads...");
        startTime = System.nanoTime();

        try (ExecutorService executor = Executors.newFixedThreadPool(1000)) {
            for (int i = 0; i < numThreads; i++) {
                final int threadNum = i;
                executor.submit(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.println("Platform Thread " + threadNum + " completed");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }

        endTime = System.nanoTime();
        duration = Duration.ofNanos(endTime - startTime);
        System.out.println("\nAll platform threads completed in " + duration.toMillis() + " ms");
    }
}