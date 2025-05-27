public class OperatorPrecedenceDemo {
    public static void main(String[] args) {
      
        System.out.println("Basic Arithmetic Operators:");
        System.out.println("--------------------------");

        int result1 = 10 + 5 * 2;
        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Result: " + result1);
        System.out.println("Explanation: Multiplication (5 * 2) is performed first, then addition (10 + 10)");
        System.out.println();

        int result2 = (10 + 5) * 2;
        System.out.println("Expression: (10 + 5) * 2");
        System.out.println("Result: " + result2);
        System.out.println("Explanation: Parentheses force addition first (10 + 5), then multiplication (15 * 2)");
        System.out.println();

        System.out.println("Mixed Operators:");
        System.out.println("---------------");

        int result3 = 10 + 5 * 2 - 3;
        System.out.println("Expression: 10 + 5 * 2 - 3");
        System.out.println("Result: " + result3);
        System.out.println(
                "Explanation: Multiplication first (5 * 2), then addition (10 + 10), then subtraction (20 - 3)");
        System.out.println();

        double result4 = 10.0 / 2 + 3 * 2;
        System.out.println("Expression: 10.0 / 2 + 3 * 2");
        System.out.println("Result: " + result4);
        System.out.println(
                "Explanation: Division (10.0 / 2) and multiplication (3 * 2) are performed first, then addition");
        System.out.println();

       
        System.out.println("Modulus and Division:");
        System.out.println("---------------------");

        int result5 = 10 % 3 * 2;
        System.out.println("Expression: 10 % 3 * 2");
        System.out.println("Result: " + result5);
        System.out.println("Explanation: Modulus (10 % 3) is performed first, then multiplication (1 * 2)");
        System.out.println();

        System.out.println("Unary Operators:");
        System.out.println("----------------");

        int x = 5;
        int result6 = ++x * 2;
        System.out.println("Expression: ++x * 2 (where x starts as 5)");
        System.out.println("Result: " + result6);
        System.out.println("Explanation: Pre-increment (++x) is performed first, then multiplication (6 * 2)");
        System.out.println();

        
        System.out.println("Complex Expression:");
        System.out.println("------------------");

        int a = 5, b = 3, c = 2;
        int result7 = a + b * c - (a - b) / c;
        System.out.println("Expression: a + b * c - (a - b) / c (where a=5, b=3, c=2)");
        System.out.println("Result: " + result7);
        System.out.println(
                "Explanation: Parentheses first (a - b), then multiplication (b * c) and division ((a - b) / c),");
        System.out.println("            then addition and subtraction from left to right");
        System.out.println();

        System.out.println("Operator Precedence (from highest to lowest):");
        System.out.println("--------------------------------------------");
        System.out.println("1. Postfix operators: x++, x--");
        System.out.println("2. Prefix operators: ++x, --x, +x, -x, !, ~");
        System.out.println("3. Multiplicative: *, /, %");
        System.out.println("4. Additive: +, -");
        System.out.println("5. Shift: <<, >>, >>>");
        System.out.println("6. Relational: <, <=, >, >=, instanceof");
        System.out.println("7. Equality: ==, !=");
        System.out.println("8. Bitwise AND: &");
        System.out.println("9. Bitwise XOR: ^");
        System.out.println("10. Bitwise OR: |");
        System.out.println("11. Logical AND: &&");
        System.out.println("12. Logical OR: ||");
        System.out.println("13. Ternary: ? :");
        System.out.println("14. Assignment: =, +=, -=, *=, /=, %=, etc.");
    }
}