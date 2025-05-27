public class CarDemo {
    public static void main(String[] args) {
        System.out.println("Car Class Demonstration");
        System.out.println("======================");

        Car car1 = new Car("Toyota", "Camry", 2020);
        Car car2 = new Car("Ford", "Mustang", 1995);
        Car car3 = new Car("Tesla", "Model 3", 2023);

        // Display details of each car
        System.out.println("\nDisplaying Car Details:");
        System.out.println("----------------------");

        // Car 1
        car1.displayDetails();
        System.out.println("Age: " + car1.getAge() + " years");
        System.out.println("Is Vintage: " + (car1.isVintage() ? "Yes" : "No"));

        // Car 2
        car2.displayDetails();
        System.out.println("Age: " + car2.getAge() + " years");
        System.out.println("Is Vintage: " + (car2.isVintage() ? "Yes" : "No"));

        // Car 3
        car3.displayDetails();
        System.out.println("Age: " + car3.getAge() + " years");
        System.out.println("Is Vintage: " + (car3.isVintage() ? "Yes" : "No"));

        // Demonstrate setter methods
        System.out.println("\nModifying Car Details:");
        System.out.println("---------------------");

        // Modify car1's make
        System.out.println("\nChanging " + car1.getMake() + "'s make to Honda");
        car1.setMake("Honda");
        car1.displayDetails();

        // Modify car2's year
        System.out.println("\nChanging " + car2.getMake() + "'s year to 1990");
        car2.setYear(1990);
        car2.displayDetails();
        System.out.println("Is Vintage: " + (car2.isVintage() ? "Yes" : "No"));

        Car myCar = new Car("Toyota", "Camry", 2020);
        myCar.start();
        myCar.accelerate(60);
        myCar.brake();
        myCar.stop();
        System.out.println("Car Info: " + myCar.getInfo());
    }
}