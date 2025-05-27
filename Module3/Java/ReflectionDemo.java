import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> targetClass = Class.forName("ReflectionTarget");
            System.out.println("Class name: " + targetClass.getName());

            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : targetClass.getDeclaredConstructors()) {
                System.out.println(constructor);
            }

            System.out.println("\nFields:");
            for (Field field : targetClass.getDeclaredFields()) {
                System.out.println(field);
            }

            System.out.println("\nMethods:");
            for (Method method : targetClass.getDeclaredMethods()) {
                System.out.println(method);
            }

            System.out.println("\nCreating instance using reflection:");
            ReflectionTarget instance = (ReflectionTarget) targetClass.getDeclaredConstructor().newInstance();
            instance.displayInfo();

            System.out.println("\nAccessing private field:");
            Field nameField = targetClass.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(instance, "Reflected Name");
            System.out.println("New name: " + instance.getName());

            System.out.println("\nInvoking private method:");
            Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(instance);

        } catch (Exception e) {
            System.err.println("Reflection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}