import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentMapManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> studentMap = new HashMap<>();

        System.out.println("Student Map Manager");
        System.out.println("==================");

        while (true) {
           
            System.out.println("\nOptions:");
            System.out.println("1. Add a student");
            System.out.println("2. Look up a student by ID");
            System.out.println("3. Display all students");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice (1-4): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addStudent(scanner, studentMap);
                        break;
                    case 2:
                        lookUpStudent(scanner, studentMap);
                        break;
                    case 3:
                        displayAllStudents(studentMap);
                        break;
                    case 4:
                        System.out.println("\nThank you for using Student Map Manager!");
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

   
    private static void addStudent(Scanner scanner, Map<Integer, String> students) {
        try {
            System.out.print("\nEnter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            if (students.containsKey(id)) {
                System.out.println("Error: Student ID " + id + " already exists.");
                return;
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty.");
                return;
            }

            students.put(id, name);
            System.out.println("Student added successfully!");
            System.out.println("Total students: " + students.size());

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid ID number.");
            scanner.nextLine();
        }
    }

   
    private static void lookUpStudent(Scanner scanner, Map<Integer, String> students) {
        try {
            System.out.print("\nEnter student ID to look up: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            String name = students.get(id);
            if (name != null) {
                System.out.println("\nStudent found:");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
            } else {
                System.out.println("\nNo student found with ID: " + id);
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid ID number.");
            scanner.nextLine(); 
        }
    }

  
    private static void displayAllStudents(Map<Integer, String> students) {
        if (students.isEmpty()) {
            System.out.println("\nNo students in the database.");
            return;
        }

        System.out.println("\nStudent Database:");
        System.out.println("----------------");
        System.out.printf("%-10s %s%n", "ID", "Name");
        System.out.println("----------------");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.printf("%-10d %s%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nTotal students: " + students.size());
    }
}