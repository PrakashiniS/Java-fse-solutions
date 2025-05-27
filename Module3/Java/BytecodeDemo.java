public class BytecodeDemo {
    private int count;
    private static final String GREETING = "Hello";

    public BytecodeDemo() {
        this.count = 0;
    }

    public int calculate(int a, int b) {
        int sum = a + b;
        count++;
        return sum;
    }

    public String greet(String name) {
        if (name == null) {
            return GREETING;
        }
        return GREETING + ", " + name + "!";
    }

    public static void main(String[] args) {
        BytecodeDemo demo = new BytecodeDemo();
        int result = demo.calculate(5, 3);
        String message = demo.greet("World");
        System.out.println(message + " Result: " + result);
    }
}