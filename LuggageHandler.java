import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class LuggageHandler {
    public static void handleLuggagePrompt(Scanner scanner, Passenger passenger) {
        System.out.println("\nDo you want your luggage(s) to be handled? (Y/N)");
        char handleLuggage = scanner.next().charAt(0);
        switch (Character.toUpperCase(handleLuggage)) {
            case 'Y': {
                handleLuggage(scanner, passenger);
                break;
            }
            case 'N': {
                passenger.setBaggageTag("not applicable");
                break;
            }
            default: {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                handleLuggagePrompt(scanner, passenger);
            }
        }
    }

    public static void handleLuggage(Scanner scanner, Passenger passenger) {
        System.out.println("\nHow many luggages do you have?");
        int numLuggages = getValidIntegerInput(scanner);

        while (numLuggages <= 0 || numLuggages >= 4) {
            if (numLuggages <= 0) {
                System.out.println("Invalid number of luggages. Please enter a positive value.");
            } else {
                System.out.println("Maximum luggage allowed per passenger is 3.");
            }
            numLuggages = getValidIntegerInput(scanner);
        }

        boolean hasDangerousItems = inquireAboutDangerousMaterials(scanner); //for BAGGAGE SCREENING 

        if (hasDangerousItems) {
            System.out.println("You can't check in due to the presence of dangerous materials or banned items.");
            System.out.println("Please remove any illegal items and try again.");
            System.out.println("Do you want to restart the check-in ?");

            char restartChoice = scanner.next().charAt(0);
            if (Character.toUpperCase(restartChoice) == 'Y') {
                handleLuggage(scanner, passenger);
            } else {
                System.out.println("Thank you for using our service.");
                System.exit(0);
            }
        }

        double totalWeight = 0.0;
        for (int i = 1; i <= numLuggages; i++) {
            System.out.print("Enter the weight for luggage " + i + " (in kg): ");
            double luggageWeight = getValidDoubleInput(scanner);

            while (luggageWeight < 0 || luggageWeight > 30) {
                if (luggageWeight < 0) {
                    System.out.println("Invalid luggage weight! Please enter a non-negative value.");
                } else {
                    System.out.println("Maximum luggage weight is 30 kg.");
                }
                luggageWeight = getValidDoubleInput(scanner);
            }

            totalWeight += luggageWeight;
        }

        passenger.setLuggageWeight(totalWeight);
        passenger.setBaggageTag(generateRandomTag());

        System.out.println("\nProcessing Weight...");
        System.out.println("Printing baggage tag: " + passenger.getBaggageTag());
        System.out.println("Completed.\n");
        System.out.println("\nPress any key to Continue.");
        scanner.nextLine(); // Consume newline left by nextDouble()
        scanner.nextLine(); // Wait for user input
        System.out.println();
    }

    public static boolean inquireAboutDangerousMaterials(Scanner scanner) {
        System.out.println("\nDo you have any dangerous materials or banned items in your luggage? (Y/N)");
        char hasDangerousItems = scanner.next().charAt(0);
        return Character.toUpperCase(hasDangerousItems) == 'Y';
    }

    private static int getValidIntegerInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static String generateRandomTag() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
