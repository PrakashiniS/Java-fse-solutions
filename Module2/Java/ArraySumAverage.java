import java.util.Scanner;
import java.util.Arrays;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int sum = calculateSum(numbers);
        double average = calculateAverage(numbers);
        int max = findMax(numbers);
        int min = findMin(numbers);

        System.out.println("\nArray: " + Arrays.toString(numbers));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        scanner.close();
    }

    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static double calculateAverage(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        return (double) calculateSum(arr) / arr.length;
    }

    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}