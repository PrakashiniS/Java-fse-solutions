import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaSortDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Alice", "Bob", "Charlie", "David", "Eve",
                "Frank", "Grace", "Henry", "Ivy", "Jack");

        System.out.println("Original list:");
        names.forEach(System.out::println);

        System.out.println("\nSorted alphabetically:");
        names.sort((a, b) -> a.compareTo(b));
        names.forEach(System.out::println);

        System.out.println("\nSorted by length:");
        names.sort((a, b) -> Integer.compare(a.length(), b.length()));
        names.forEach(System.out::println);

        System.out.println("\nSorted by length (descending):");
        names.sort((a, b) -> Integer.compare(b.length(), a.length()));
        names.forEach(System.out::println);

        System.out.println("\nSorted by last character:");
        names.sort((a, b) -> Character.compare(
                a.charAt(a.length() - 1),
                b.charAt(b.length() - 1)));
        names.forEach(System.out::println);
    }
}