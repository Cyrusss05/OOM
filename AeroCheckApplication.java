import java.util.Scanner;

public class AeroCheckApplication {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            displayWelcomeScreen(1);
            int desiredOption = getDesiredOption(scanner);
            
            if (desiredOption == 1) {
                // Single Passenger Check-in logic
                handleSinglePassengerCheckIn(scanner);
            } else if (desiredOption == 2) {
                // Group Passenger Check-in logic
                handleGroupPassengerCheckIn(scanner);
            }
            
            // Additional application logic if needed
        }
    }

    private static void displayWelcomeScreen(int option) {
        UserInterface.displayWelcomeScreen(option);
    }
    
    private static int getDesiredOption(Scanner scanner) {
        while (true) {
            System.out.println("\n\n\t\t(0) Exit.");
            System.out.println("\t\t(1) Single Passenger Check-in.");
            System.out.println("\t\t(2) Group Passenger Check-in.");
            System.out.print("Enter the desired option:    ");
            int desiredOption = InputValidator.getValidInt(scanner, "\nInvalid input. Please enter a valid value.\n");

            if (desiredOption >= 0 && desiredOption <= 2) {
                return desiredOption;
            } else {
                System.out.print("\nERROR!! Please enter value between 0 - 2. Enter the value again.\n");
            }
        }
    }

    private static void handleSinglePassengerCheckIn(Scanner scanner) {
        System.out.print("\nEnter Full Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Age: ");
        int age = InputValidator.getValidInt(scanner, "Invalid age. Please enter a valid age.");

        System.out.print("Gender (M/F): ");
        char gender = InputValidator.getValidChar(scanner, "Invalid gender. Please enter M or F.");

        Passenger passenger = new Passenger(name, age, gender);

        // Additional logic for single passenger check-in
    }

    private static void handleGroupPassengerCheckIn(Scanner scanner) {
        System.out.print("Number of Passengers: ");
        int numberOfPassengers = InputValidator.getValidInt(scanner, "Invalid number of passengers. Please enter a valid number.");
        
        for (int i = 0; i < numberOfPassengers; i++) {
            System.out.print("Enter Full Name of Passenger " + (i + 1) + ": ");
            String name = scanner.next();
    
            System.out.print("Age of Passenger " + (i + 1) + ": ");
            int age = InputValidator.getValidInt(scanner, "Invalid age. Please enter a valid age.");
    
            System.out.print("Gender of Passenger " + (i + 1) + " (M/F): ");
            char gender = InputValidator.getValidChar(scanner, "Invalid gender. Please enter M or F.");

            Passenger passenger = new Passenger(name, age, gender);
            
            // Additional logic for group passenger check-in
        }
    }
}
