import java.util.Scanner;

public class LuggageHandler {
    public static void handleLuggage(Scanner scanner, Passenger passenger) {
        System.out.println("\t\tPlease place your luggage(s) on the weighing scale");
        scanner.nextLine(); // Consume the newline character
        System.out.println("\t\tPress any key to Continue.");
        
        // Wait for user input
        
        // Assuming you have created a Passenger instance named passenger
        passenger.setLuggageWeight(scanner.nextDouble());
        
        System.out.println("\t\tProcessing Weight...");
        System.out.println("\t\tPrinting baggage tag...");
        System.out.println("\t\tCompleted.\n");
        System.out.println("\t\tPress any key to Continue.");
        scanner.nextLine(); // Wait for user input
        System.out.println();
    }
}
