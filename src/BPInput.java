import java.util.Scanner;

public class BPInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumInRange(String input, int min, int max) {
        while (true) {
            System.out.print(input + " ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Enter a number between " + min + " and " + max);
                }
            } else {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }

    public static double getDoubleMin(String input, double min) {
        while (true) {
            System.out.print(input + " ");
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                if (value >= min) {
                    return value;
                } else {
                    System.out.println("Invalid input");
                }
            } else {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }
}
