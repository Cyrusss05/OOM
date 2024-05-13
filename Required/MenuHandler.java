import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuHandler {
    public static int displayMenuAndGetOption(Scanner scanner) {
        int desiredOption;
        while (true) {
            System.out.println("\n\n\t\t(0) Exit.");
            System.out.println("\t\t(1) self-service kiosks for Single Passenger Check-in.");
            System.out.println("\t\t(2) self-service kiosks for Group Passenger Check-in.");
            System.out.println("\t\t(3) designated counters\n\n");
            System.out.print("Enter the desired option:    ");
            try {
                desiredOption = scanner.nextInt();
                if (desiredOption < 0 || desiredOption > 3) {
                    System.out.print("\nERROR!! Please enter value between 0 - 3. Enter the value again.\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid value.\n");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return desiredOption;
    }
}
