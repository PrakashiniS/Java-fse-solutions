public class ReflectionTarget {
    private String name;
    private int value;

    public ReflectionTarget() {
        this.name = "Default";
        this.value = 0;
    }

    public ReflectionTarget(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void sayHello() {
        System.out.println("Hello from " + name + "!");
    }

    public int calculate(int a, int b) {
        return a + b + value;
    }

    private void privateMethod() {
        System.out.println("This is a private method");
    }

    public void publicMethod() {
        System.out.println("This is a public method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Value: " + value);
    }
}