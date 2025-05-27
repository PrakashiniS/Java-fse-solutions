import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter marks (out of 100): ");
        int marks = scanner.nextInt();

      
        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks should be between 0 and 100");
            scanner.close();
            return;
        }

       
        String grade;
        if (marks >= 90 && marks <= 100) {
            grade = "A";
        } else if (marks >= 80 && marks <= 89) {
            grade = "B";
        } else if (marks >= 70 && marks <= 79) {
            grade = "C";
        } else if (marks >= 60 && marks <= 69) {
            grade = "D";
        } else {
            grade = "F";
        }

       
        System.out.println("\nGrade Calculation Result:");
        System.out.println("------------------------");
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);

      
        System.out.println("\nFeedback:");
        System.out.println("---------");
        switch (grade) {
            case "A":
                System.out.println("Excellent! Keep up the great work!");
                break;
            case "B":
                System.out.println("Good job! You're doing well!");
                break;
            case "C":
                System.out.println("Satisfactory. There's room for improvement.");
                break;
            case "D":
                System.out.println("You need to work harder to improve.");
                break;
            case "F":
                System.out.println("You need to put in more effort to pass.");
                break;
        }

        scanner.close();
    }
}