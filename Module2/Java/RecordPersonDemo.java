import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecordPersonDemo {
   
    public record Person(String name, int age) {
    }

    public static void main(String[] args) {
     
                Person p1 = new Person("Alice", 22);
        Person p2 = new Person("Bob", 17);
        Person p3 = new Person("Charlie", 30);
        Person p4 = new Person("Diana", 15);
        Person p5 = new Person("Eve", 19);

       
        System.out.println("Individual Person Records:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

        List<Person> people = Arrays.asList(p1, p2, p3, p4, p5);

       
        List<Person> adults = people.stream()
                .filter(person -> person.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(System.out::println);
    }
}