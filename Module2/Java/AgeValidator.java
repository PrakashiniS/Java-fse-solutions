import java.util.Scanner;

public class AgeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            validateAge(age);
            System.out.println("Age is valid: " + age);

        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid number");
        } finally {
            scanner.close();
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative");
        }
        if (age > 150) {
            throw new InvalidAgeException("Age seems unrealistic");
        }
    }
}