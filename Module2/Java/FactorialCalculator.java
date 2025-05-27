 import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Enter a non-negative integer: ");
        
       
        if (!scanner.hasNextInt()) {
            System.out.println("Error: Please enter a valid integer!");
            scanner.close();
            return;
        }
        
        int number = scanner.nextInt();
        
       
        if (number < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers!");
            scanner.close();
            return;
        }
        
       
        long factorial = 1;
        
       
        if (number == 0) {
            System.out.println("0! = 1");
        } else {
         
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            
         
            System.out.println("\nFactorial Calculation:");
            System.out.println("---------------------");
            System.out.print(number + "! = ");
            for (int i = 1; i <= number; i++) {
                System.out.print(i);
                if (i < number) {
                    System.out.print(" × ");
                }
            }
            System.out.println(" = " + factorial);
            
          
            System.out.println("\nNote: Factorial of " + number + " is " + factorial);
            if (number > 20) {
                System.out.println("Warning: Result might be inaccurate due to long integer overflow!");
            }
        }
        
        scanner.close();
    }
}