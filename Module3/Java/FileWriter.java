import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "output.txt";

        System.out.println("File Writing Program");
        System.out.println("===================");

        try {
           
            System.out.print("\nEnter text to write to file: ");
            String userInput = scanner.nextLine();

           
            String timestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

          
            writeToFile(fileName, userInput, timestamp);

           
            System.out.println("\nSuccess! Data has been written to " + fileName);
            System.out.println("Timestamp: " + timestamp);

        } catch (IOException e) {
            System.out.println("\nError writing to file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

       private static void writeToFile(String fileName, String content, String timestamp)
            throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
           
            writer.println("\n----------------------------------------");

           
            writer.println("Timestamp: " + timestamp);

            
            writer.println("Content: " + content);

           
            writer.println("----------------------------------------");
        }
    }
}