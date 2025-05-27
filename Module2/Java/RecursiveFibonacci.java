import java.util.Scanner;

public class RecursiveFibonacci {
   
    public static long fibonacci(int n) {
       
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be positive");
        }
        if (n == 1 || n == 2) {
            return 1;
        }

      
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fibonacci Number Calculator");
        System.out.println("==========================");
        System.out.println("This program calculates the nth Fibonacci number using recursion.");
        System.out.println("Note: For large values of n, the calculation might take some time.");

        try {
       
            System.out.print("\nEnter a positive integer n: ");
            int n = scanner.nextInt();

          
            if (n <= 0) {
                System.out.println("Error: Please enter a positive integer!");
                return;
            }

           
            System.out.println("\nCalculating Fibonacci number...");
            long result = fibonacci(n);

           
            System.out.println("\nResult:");
            System.out.println("-------");
            System.out.println("F(" + n + ") = " + result);

            
            System.out.println("\nFibonacci sequence up to F(" + n + "):");
            System.out.println("--------------------------------");
            for (int i = 1; i <= n; i++) {
                System.out.print("F(" + i + ") = " + fibonacci(i));
                if (i < n) {
                    System.out.print(", ");
                }
            }
            System.out.println();

           
            if (n > 40) {
                System.out.println("\nWarning: For n > 40, the calculation might be slow due to recursive nature.");
                System.out.println("Consider using an iterative approach for better performance.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}