import java.util.Scanner;

public class DivisionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Division Calculator");
        System.out.println("==================");

        try {
           
            System.out.print("\nEnter the first number (numerator): ");
            int numerator = scanner.nextInt();

         
            System.out.print("Enter the second number (denominator): ");
            int denominator = scanner.nextInt();

            
            try {
                double result = divide(numerator, denominator);
                System.out.println("\nResult: " + numerator + " / " + denominator + " = " + result);
            } catch (ArithmeticException e) {
                System.out.println("\nError: " + e.getMessage());
                System.out.println("Please enter a non-zero denominator.");
            }

        } catch (Exception e) {
            System.out.println("\nError: Invalid input. Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }

       public static double divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) numerator / denominator;
    }
}