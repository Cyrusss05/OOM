import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputValidator {
    public static int getValidInt(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static char getValidChar(Scanner scanner, String errorMessage) {
        while (true) {
            String input = scanner.next();
            if (input.length() != 1) {
                System.out.println(errorMessage);
            } else {
                char c = input.charAt(0);
                if (c != 'M' && c != 'F' && c != 'm' && c != 'f') {
                    System.out.println(errorMessage);
                } else {
                    return Character.toUpperCase(c);
                }
            }
        }
    }

    public static long getValidLong(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                return scanner.nextLong();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static LocalDate getValidDate(Scanner scanner, String errorMessage) {
        while (true) {
            String dateInput = scanner.next();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                return LocalDate.parse(dateInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(errorMessage);
            }
        }
    }
}
