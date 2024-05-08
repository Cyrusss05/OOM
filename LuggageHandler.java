import java.util.Scanner;

public class LuggageHandler {
    public static void handleLuggage(Scanner scanner) {
        System.out.println("\t\tPlease place your luggage(s) on the weighing scale");
        scanner.nextLine(); // Consume the newline character
        System.out.println("\t\tPress Enter to Continue.");
        scanner.nextLine(); // Wait for user input
        System.out.println("\t\tProcessing Weight...");
        System.out.println("\t\tPrinting baggage tag...");
        System.out.println("\t\tCompleted.\n");
        System.out.println("\t\tPress Enter to Continue.");
        scanner.nextLine(); // Wait for user input
        System.out.println();
    }
}
