import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentListManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();

        System.out.println("Student List Manager");
        System.out.println("===================");

        while (true) {
           
            System.out.println("\nOptions:");
            System.out.println("1. Add a student name");
            System.out.println("2. Display all students");
            System.out.println("3. Sort students alphabetically");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice (1-4): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        addStudent(scanner, studentNames);
                        break;
                    case 2:
                        displayStudents(studentNames);
                        break;
                    case 3:
                        sortStudents(studentNames);
                        break;
                    case 4:
                        System.out.println("\nThank you for using Student List Manager!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("\nInvalid choice. Please enter a number between 1 and 4.");
                }
            } catch (Exception e) {
                System.out.println("\nError: Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
    }

   
    private static void addStudent(Scanner scanner, ArrayList<String> students) {
        System.out.print("\nEnter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        if (students.contains(name)) {
            System.out.println("Error: This name already exists in the list.");
            return;
        }

        students.add(name);
        System.out.println("Student '" + name + "' added successfully!");
        System.out.println("Total students: " + students.size());
    }

       private static void displayStudents(ArrayList<String> students) {
        if (students.isEmpty()) {
            System.out.println("\nNo students in the list.");
            return;
        }

        System.out.println("\nStudent List:");
        System.out.println("-------------");
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, students.get(i));
        }
        System.out.println("\nTotal students: " + students.size());
    }

    
    private static void sortStudents(ArrayList<String> students) {
        if (students.isEmpty()) {
            System.out.println("\nNo students to sort.");
            return;
        }

        Collections.sort(students);
        System.out.println("\nStudents sorted alphabetically:");
        displayStudents(students);
    }
}