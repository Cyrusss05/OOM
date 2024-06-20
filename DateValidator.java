import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateValidator {
    public static LocalDate getValidDate(Scanner scanner, String errorMessage) {
        while (true) {
            String dateInput = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                LocalDate enteredDate = LocalDate.parse(dateInput, formatter);
                LocalDate currentDate = LocalDate.now();
                if (enteredDate.isBefore(currentDate)) {
                    System.out.println("Error: Date cannot be before the current date.");
                    System.out.print("Enter a valid future date (dd/MM/yyyy): ");
                } else {
                    return enteredDate;
                }
            } catch (DateTimeParseException e) {
                System.out.println(errorMessage);
                System.out.print("Enter a valid date format (dd/MM/yyyy): ");
            }
        }
    }
}
