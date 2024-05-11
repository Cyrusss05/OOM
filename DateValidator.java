import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateValidator {
    public static LocalDate getValidDate(Scanner scanner, String errorMessage) {
        while (true) {
            String dateOfFlight = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                return LocalDate.parse(dateOfFlight, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(errorMessage);
                System.out.print("Enter a valid date format (dd/mm/yyyy): ");
            }
        }
    }
}
