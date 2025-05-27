import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

      
        int targetNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Can you guess it?");

     
        while (!hasWon && attempts < 10) {
            System.out.print("\nEnter your guess: ");

         
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next(); 
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            // Check if guess is within valid range
            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a number between 1 and 100!");
                continue;
            }

            // Provide feedback
            if (guess < targetNumber) {
                System.out.println("Too low! Try a higher number.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try a lower number.");
            } else {
                hasWon = true;
                System.out.println("\nCongratulations! You've won!");
                System.out.println("The number was: " + targetNumber);
                System.out.println("Number of attempts: " + attempts);
            }

            // Show remaining attempts
            if (!hasWon) {
                System.out.println("Attempts remaining: " + (10 - attempts));
            }
        }

        // Game over message if player runs out of attempts
        if (!hasWon) {
            System.out.println("\nGame Over! You've run out of attempts.");
            System.out.println("The number was: " + targetNumber);
        }

        scanner.close();
    }
}