public class InvalidAgeException extends Exception {
    private int age;

  
    public InvalidAgeException(String message) {
        super(message);
    }

   
    public InvalidAgeException(String message, int age) {
        super(message);
        this.age = age;
    }

   
    public int getAge() {
        return age;
    }

   
    @Override
    public String toString() {
        return "InvalidAgeException: " + getMessage() +
                (age != 0 ? " (Provided age: " + age + ")" : "");
    }
}