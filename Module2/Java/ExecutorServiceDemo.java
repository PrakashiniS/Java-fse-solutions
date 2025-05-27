import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            Callable<Integer> task = () -> {
                System.out.println("Task " + taskId + " started");
                Thread.sleep(1000);
                System.out.println("Task " + taskId + " completed");
                return taskId * 10;
            };
            futures.add(executor.submit(task));
        }

        System.out.println("All tasks submitted");

        for (Future<Integer> future : futures) {
            try {
                int result = future.get();
                System.out.println("Task result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error getting task result: " + e.getMessage());
            }
        }

        executor.shutdown();
    }
}

class CalculationTask implements Callable<Integer> {
    private final int taskId;

    public CalculationTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public Integer call() throws Exception {
        System.out.printf("Task %d started%n", taskId);

        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            result += i;
        }

        Thread.sleep(1000);

        System.out.printf("Task %d completed%n", taskId);
        return result;
    }
}