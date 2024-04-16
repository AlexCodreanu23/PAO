package task5;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleUnaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumbers = readIntFromScanner(scanner, "Enter the total number of numbers:");

        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < totalNumbers; i++) {
            double number = readDoubleFromScanner(scanner, "Enter number " + (i + 1) + ":");
            numbers.add(number);
        }

        List<DoubleUnaryOperator> operations = Arrays.asList(
                num -> num * ThreadLocalRandom.current().nextDouble(),
                num -> num + 1,
                num -> 1 / num,
                num -> num * num,
                Math::sin
        );

        Random random = new Random();
        for (double number : numbers) {
            DoubleUnaryOperator operation = operations.get(random.nextInt(operations.size()));
            double result = operation.applyAsDouble(number);
            System.out.println("Result of operation on " + number + ": " + result);
        }

        scanner.close();
    }
    private static int readIntFromScanner(Scanner scanner, String message) {
        int number;
        while (true) {
            try {
                System.out.println(message);
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return number;
    }

    private static double readDoubleFromScanner(Scanner scanner, String message) {
        double number;
        while (true) {
            try {
                System.out.println(message);
                number = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return number;
    }
}
