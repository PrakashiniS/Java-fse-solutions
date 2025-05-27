public class MethodOverloadingDemo {
   
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

   
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
      
        System.out.println("Method Overloading Demo");
        System.out.println("======================");

        
        int num1 = 5, num2 = 10;
        System.out.println("\nAdding two integers:");
        System.out.println("add(" + num1 + ", " + num2 + ") = " + add(num1, num2));

       
        double d1 = 3.14, d2 = 2.86;
        System.out.println("\nAdding two doubles:");
        System.out.println("add(" + d1 + ", " + d2 + ") = " + add(d1, d2));

       
        int num3 = 15;
        System.out.println("\nAdding three integers:");
        System.out.println("add(" + num1 + ", " + num2 + ", " + num3 + ") = " + add(num1, num2, num3));

       
        System.out.println("\nAdditional Test Cases:");
        System.out.println("---------------------");

        
        System.out.println("add(10, 20) = " + add(10, 20));
        System.out.println("add(10.5, 20.5) = " + add(10.5, 20.5));
        System.out.println("add(10, 20, 30) = " + add(10, 20, 30));

        
        System.out.println("\nTesting with mixed types:");
        System.out.println("add(10, 20.5) = " + add(10, 20.5)); 
    }
}