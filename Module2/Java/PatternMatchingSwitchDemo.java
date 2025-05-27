public class PatternMatchingSwitchDemo {
    public static void main(String[] args) {
        Object[] objects = {
                "Hello",
                42,
                3.14,
                new int[] { 1, 2, 3 },
                null
        };

        for (Object obj : objects) {
            String result = switch (obj) {
                case String s -> "String: " + s;
                case Integer i -> "Integer: " + i;
                case Double d -> "Double: " + d;
                case int[] arr -> "Array with " + arr.length + " elements";
                case null -> "null value";
                default -> "Unknown type: " + obj.getClass().getName();
            };
            System.out.println(result);
        }
    }
}