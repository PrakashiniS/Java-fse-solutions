import java.util.Scanner;

public class StringReversal {
       public static String reverseWithStringBuilder(String input) {
        return new StringBuilder(input).reverse().toString();
    }

   
    public static String reverseWithLoop(String input) {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
           
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

           
            left++;
            right--;
        }

        return new String(chars);
    }

   
    public static String reverseWithRecursion(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        return reverseWithRecursion(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("String Reversal Program");
        System.out.println("======================");

        try {
           
            System.out.print("Enter a string to reverse: ");
            String input = scanner.nextLine();

           
            if (input == null || input.trim().isEmpty()) {
                System.out.println("Error: Please enter a non-empty string!");
                return;
            }

         
            System.out.println("\nOriginal string: \"" + input + "\"");

            
            System.out.println("\nReversed strings using different methods:");
            System.out.println("----------------------------------------");

           
            String reversed1 = reverseWithStringBuilder(input);
            System.out.println("1. Using StringBuilder: \"" + reversed1 + "\"");

            
            String reversed2 = reverseWithLoop(input);
            System.out.println("2. Using Loop: \"" + reversed2 + "\"");

            
            String reversed3 = reverseWithRecursion(input);
            System.out.println("3. Using Recursion: \"" + reversed3 + "\"");

           
            System.out.println("\nAdditional Information:");
            System.out.println("----------------------");
            System.out.println("String length: " + input.length());
            System.out.println("Is palindrome: " + (input.equalsIgnoreCase(reversed1) ? "Yes" : "No"));

        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}