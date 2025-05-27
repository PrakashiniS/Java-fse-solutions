import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderDemo {
    public static void main(String[] args) {
        String fileName = "output.txt";

        System.out.println("File Reading Program");
        System.out.println("===================");

      
        Path filePath = Paths.get(fileName);
        if (!Files.exists(filePath)) {
            System.out.println("\nError: File '" + fileName + "' does not exist.");
            return;
        }

        try {
         
            System.out.println("\nReading contents of " + fileName + ":");
            System.out.println("----------------------------------------");

            readFile(fileName);

           
            displayFileStats(filePath);

        } catch (IOException e) {
            System.out.println("\nError reading file: " + e.getMessage());
        }
    }

  
    private static void readFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.printf("Line %d: %s%n", lineNumber++, line);
            }
        }
    }

  
    private static void displayFileStats(Path filePath) throws IOException {
        System.out.println("\nFile Statistics:");
        System.out.println("----------------");

       
        long size = Files.size(filePath);
        System.out.println("File size: " + size + " bytes");

      
        long lines = Files.lines(filePath).count();
        System.out.println("Number of lines: " + lines);

       
        String lastModified = Files.getLastModifiedTime(filePath).toString();
        System.out.println("Last modified: " + lastModified);
    }
}