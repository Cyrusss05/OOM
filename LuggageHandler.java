import java.util.Scanner;

public class LuggageHandler {
    public static void handleLuggage(Scanner scanner) {
        System.out.println("\t\tDo you want your luggage(s) to be handled? (Y/N)");
        char handleLuggage = scanner.next().charAt(0);
        if (handleLuggage == 'Y' || handleLuggage == 'y') {
            System.out.println("\t\tPlease place your luggage(s) on the weighing scale");
            System.out.println("\t\tPress any key to Continue.");
            scanner.next(); // Wait for user input
            System.out.println("\t\tProccessing Weight...");
            System.out.println("\t\tPrinting baggage tag...");
            System.out.println("\t\tCompleted.\n");
            System.out.println("\t\tPress any key to Continue.");
            scanner.next(); // Wait for user input
        } else {
            System.out.println("\t\tLuggage handling skipped.");
        }
    }
}
