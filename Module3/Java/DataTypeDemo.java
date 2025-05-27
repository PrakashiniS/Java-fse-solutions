public class DataTypeDemo {
    public static void main(String[] args) {
       
        int age = 25;
        System.out.println("Integer (int) example:");
        System.out.println("Age: " + age);
        System.out.println("Range: -2,147,483,648 to 2,147,483,647");
        System.out.println();

        
        float temperature = 98.6f;
        System.out.println("Float example:");
        System.out.println("Temperature: " + temperature);
        System.out.println("Range: ±3.40282347E+38F");
        System.out.println();

    
        double pi = 3.14159265359;
        System.out.println("Double example:");
        System.out.println("Value of Pi: " + pi);
        System.out.println("Range: ±1.79769313486231570E+308");
        System.out.println();

      
        char grade = 'A';
        System.out.println("Character (char) example:");
        System.out.println("Grade: " + grade);
        System.out.println("Range: '\\u0000' to '\\uffff'");
        System.out.println();

     
        boolean isJavaFun = true;
        System.out.println("Boolean example:");
        System.out.println("Is Java Fun? " + isJavaFun);
        System.out.println("Possible values: true or false");
        System.out.println();

       
        System.out.println("Additional Examples:");
        System.out.println("-------------------");

       
        int sum = 100 + 50;
        System.out.println("Integer operation (100 + 50): " + sum);

        
        float price = 19.99f;
        System.out.println("Float price: " + price);

      
        double distance = 149.6e6; 
        System.out.println("Double distance: " + distance);

      
        char nextGrade = (char) (grade + 1);
        System.out.println("Next grade after " + grade + ": " + nextGrade);

     
        boolean isWeekend = false;
        boolean isHoliday = true;
        System.out.println("Is it a good day to code? " + (isWeekend || isHoliday));
    }
}