import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class LuggageHandler {
    public static void handleLuggagePrompt(Scanner scanner, Passenger passenger) {
        // Prompt for luggage handling moved from SinglePassengerHandler
        System.out.println("\nDo you want your luggage(s) to be handled? (Y/N)");
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
        System.out.println("\nHow many luggages do you have?");
        int numLuggages;
        try {
            numLuggages = scanner.nextInt();
            if (numLuggages <= 0) {
                System.out.println("Invalid number of luggages. Please enter a positive value.");
                handleLuggage(scanner, passenger); // Re-prompt for valid input
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next(); // Clear the invalid input
            handleLuggage(scanner, passenger); // Re-prompt for valid input
            return;
        }

        System.out.println("\nPlease enter the weight for each luggage (in kg):");
        double totalWeight = 0.0;
        for (int i = 1; i <= numLuggages; i++) {
            System.out.print("Luggage " + i + ": ");
            try {
                double luggageWeight = scanner.nextDouble();
                if (luggageWeight < 0) {
                    System.out.println("Invalid luggage weight! Please enter a non-negative value.");
                    i--; // Decrement i to re-prompt for the same luggage
                    continue;
                }
                totalWeight += luggageWeight;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear the invalid input
                i--; // Decrement i to re-prompt for the same luggage
            }
        }
        
        passenger.setLuggageWeight(totalWeight);

        // Generate random baggage tag number
        String baggageTag = generateRandomTag();
        passenger.setBaggageTag(baggageTag);

        System.out.println("\nProcessing Weight...");
        System.out.println("Printing baggage tag: " + baggageTag);
        System.out.println("Completed.\n");
        System.out.println("\nPress any key to Continue.");
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
