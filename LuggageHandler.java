import java.util.Scanner;
import java.util.Random;

public class LuggageHandler {
    public static void handleLuggagePrompt(Scanner scanner, Passenger passenger) {
        // Prompt for luggage handling moved from SinglePassengerHandler
        System.out.println("\t\tDo you want your luggage(s) to be handled? (Y/N)");
        char handleLuggage = scanner.next().charAt(0);
        switch (Character.toUpperCase(handleLuggage)) {
            case 'Y': {
                handleLuggage(scanner, passenger); // Call the luggage handling method
                break;
            }
            case 'N': {
                passenger.setBaggageTag("not applicable"); // Set baggage tag to "not applicable"
                break;
            }
            default: {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                handleLuggagePrompt(scanner, passenger); // Re-prompt for valid input
            }
        }
    }

    public static void handleLuggage(Scanner scanner, Passenger passenger) {
        System.out.println("\t\tPlease place your luggage(s) on the weighing scale");
        System.out.println("\t\tPlease enter luggage weight.");

        double luggageWeight;
        boolean isValidWeight = false;

        // Loop until a valid luggage weight is entered
        while (!isValidWeight) {
            if (scanner.hasNextDouble()) {
                luggageWeight = scanner.nextDouble();
                if (luggageWeight >= 0) { // Check if the weight is non-negative
                    isValidWeight = true;
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
                } else {
                    System.out.println("\t\tInvalid luggage weight! Please enter a non-negative value.");
                    scanner.nextLine(); // Consume the invalid input
                }
            } else {
                System.out.println("\t\tInvalid input! Please enter a valid numerical value for luggage weight.");
                scanner.next(); // Consume the invalid input
            }
        }
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
