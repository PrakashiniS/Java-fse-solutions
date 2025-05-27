public class Dog extends Animal {
    private String breed;

    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }


    @Override
    public void makeSound() {
        System.out.println(name + " says: Bark!");
    }

   
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Breed: " + breed);
    }

   
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}