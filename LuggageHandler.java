import java.util.Scanner;

public class LuggageHandler {
    public static void handleLuggage(Scanner scanner, Passenger passenger) {
        System.out.println("\t\tPlease place your luggage(s) on the weighing scale");
        System.out.println("\t\tPress any key to Continue.");
        
        passenger.setLuggageWeight(scanner.nextDouble());
        
        System.out.println("\t\tProcessing Weight...");
        System.out.println("\t\tPrinting baggage tag...");
        System.out.println("\t\tCompleted.\n");
        System.out.println("\t\tPress any key to Continue.");
        scanner.nextLine(); // Wait for user input
        System.out.println();
    }
}
