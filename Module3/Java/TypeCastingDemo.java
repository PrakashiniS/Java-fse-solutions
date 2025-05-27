public class TypeCastingDemo {
    public static void main(String[] args) {
    
        System.out.println("Double to int casting:");
        System.out.println("------------------------");

        double price = 19.99;
        System.out.println("Original double value: " + price);

        
        int wholePrice = (int) price;
        System.out.println("After casting to int: " + wholePrice);
        System.out.println("Note: Decimal part is truncated");
        System.out.println();


        System.out.println("Int to double casting:");
        System.out.println("------------------------");

        int quantity = 5;
        System.out.println("Original int value: " + quantity);

    
        double doubleQuantity = quantity;
        System.out.println("After casting to double: " + doubleQuantity);
        System.out.println("Note: No data loss in this conversion");
        System.out.println();

     
        System.out.println("Additional Examples:");
        System.out.println("-------------------");

      
        double[] testValues = { 3.14, 5.99, -2.5, 10.0 };
        for (double value : testValues) {
            System.out.printf("Double: %.2f -> Int: %d%n", value, (int) value);
        }

        int[] numbers = { 10, 20, 30, 40 };
        for (int num : numbers) {
            double result = (double) num / 3; 
            System.out.printf("Int: %d -> Double division by 3: %.2f%n", num, result);
        }
    }
}