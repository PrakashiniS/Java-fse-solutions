public class Car {
    private String make;
    private String model;
    private int year;
    private double speed;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = 0.0;
    }

    public void accelerate(double amount) {
        if (amount > 0) {
            speed += amount;
            System.out.println("Accelerating to " + speed + " km/h");
        }
    }

    public void brake(double amount) {
        if (amount > 0) {
            speed = Math.max(0, speed - amount);
            System.out.println("Slowing down to " + speed + " km/h");
        }
    }

    public void stop() {
        speed = 0;
        System.out.println("Car stopped");
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getSpeed() {
        return speed;
    }

    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Current Speed: " + speed + " km/h");
    }
}