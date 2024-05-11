import java.util.Scanner;
import java.util.Random;

public class LuggageHandler {
    public static void handleLuggage(Scanner scanner, Passenger passenger) {
        System.out.println("\t\tPlease place your luggage(s) on the weighing scale");
        System.out.println("\t\tPress any key to Continue.");

        // Read luggage weight from user input
        double luggageWeight = scanner.nextDouble();
        passenger.setLuggageWeight(luggageWeight);

        // Generate random baggage tag number
        String baggageTag = generateRandomTag();
        passenger.setBaggageTag(baggageTag);

        System.out.println("\t\tProcessing Weight...");
        System.out.println("\t\tPrinting baggage tag: " + baggageTag);
        System.out.println("\t\tCompleted.\n");
        System.out.println("\t\tPress any key to Continue.");
        scanner.nextLine(); // Consume newline left by nextDouble()
        scanner.nextLine(); // Wait for user input
        System.out.println();
    }

    // Method to generate random baggage tag number
    private static String generateRandomTag() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        // Generate a random 6-digit number
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
