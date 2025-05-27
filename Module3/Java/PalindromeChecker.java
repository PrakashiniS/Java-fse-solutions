import java.util.Scanner;

public class PalindromeChecker {
 
    public static boolean isPalindrome(String input) {
        
        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

       
        if (processed.isEmpty()) {
            return false;
        }

       
        int left = 0;
        int right = processed.length() - 1;

        while (left < right) {
            if (processed.charAt(left) != processed.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

  
    public static String getProcessedString(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Palindrome Checker");
        System.out.println("=================");

        try {
          
            System.out.print("Enter a string to check: ");
            String input = scanner.nextLine();

            
            if (input == null || input.trim().isEmpty()) {
                System.out.println("Error: Please enter a non-empty string!");
                return;
            }

           
            String processed = getProcessedString(input);
            boolean isPal = isPalindrome(input);

           
            System.out.println("\nAnalysis:");
            System.out.println("---------");
            System.out.println("Original string: \"" + input + "\"");
            System.out.println("Processed string: \"" + processed + "\"");
            System.out.println("Is palindrome: " + (isPal ? "Yes" : "No"));

           
            System.out.println("\nAdditional Information:");
            System.out.println("----------------------");
            System.out.println("Original length: " + input.length());
            System.out.println("Processed length: " + processed.length());
            System.out.println("Characters removed: " + (input.length() - processed.length()));

            if (input.length() != processed.length()) {
                System.out.println("\nRemoved characters:");
                System.out.println("------------------");
                for (char c : input.toCharArray()) {
                    if (!Character.isLetterOrDigit(c)) {
                        System.out.println("- '" + c + "' (ASCII: " + (int) c + ")");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}