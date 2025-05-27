public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("Inheritance Demonstration");
        System.out.println("========================");

      
        Animal genericAnimal = new Animal("Generic Animal", 5);
        System.out.println("\nTesting Animal class:");
        genericAnimal.displayDetails();
        genericAnimal.makeSound();

        
        Dog myDog = new Dog("Buddy", 3, "Golden Retriever");
        System.out.println("\nTesting Dog class:");
        myDog.displayDetails();
        myDog.makeSound();

        
        System.out.println("\nDemonstrating Polymorphism:");
        System.out.println("-------------------------");

        Animal[] animals = new Animal[2];
        animals[0] = genericAnimal;
        animals[1] = myDog;

        
        for (Animal animal : animals) {
            System.out.println("\nAnimal: " + animal.getName());
            animal.makeSound(); 
        }
    }
}