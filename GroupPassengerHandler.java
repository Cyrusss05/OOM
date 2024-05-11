import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class GroupPassengerHandler {
    public static void handleGroupPassenger(Scanner scanner) {
        Artwork art = new Artwork();

        // Handle group passenger check-in
        int numberOfPassengers;
        while (true) {
            System.out.println("\n+++++++++++++ Group Passenger Check-in +++++++++++++");
            System.out.print("\nNumber of Passengers: ");
            try {
                numberOfPassengers= scanner.nextInt(); // Read the entire line
                if (numberOfPassengers <= 0) {
                    System.out.println("Number of passengers must be a positive integer.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the scanner buffer
            }
        }

        // Iterate through each passenger
        for (int i = 0; i < numberOfPassengers; i++) {
            Passenger passenger = new Passenger(); // Create a new passenger for each iteration
            System.out.println("\n");
            System.out.print("Enter First Name of Passenger " + (i + 1) + ": ");
            passenger.setFirstName(scanner.next());

            System.out.print("Enter Last Name of Passenger " + (i + 1) + ": ");
            passenger.setLastName(scanner.next());

            while (true) {
                System.out.print("Age of Passenger " + (i + 1) + ": ");
                try {
                    int age = scanner.nextInt();
                    if (age <= 0) {
                        System.out.println("Age must be a positive integer.");
                        continue;
                    }
                    passenger.setAge(age);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid age.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            scanner.nextLine(); // Consume the newline character

            System.out.print("Gender of Passenger " + (i + 1) + " (M/F): ");
            String genderInput = scanner.nextLine().toUpperCase();
            while (!genderInput.equals("M") && !genderInput.equals("F")) {
                System.out.println("Invalid input. Please enter M or F.");
                System.out.print("Gender of Passenger " + (i + 1) + " (M/F): ");
                genderInput = scanner.nextLine().toUpperCase();
            }
            passenger.setGender(genderInput.charAt(0));

            System.out.print("Passport Number of Passenger " + (i + 1) + ": ");
            String passportNumber = scanner.next();
            passenger.setPassportNumber(passportNumber);

            System.out.print("Date of Flight (dd/mm/yyyy) of Passenger " + (i + 1) + ": ");
            LocalDate dateOfFlight = DateValidator.getValidDate(scanner, "Invalid Date. Please enter valid Date.");
            passenger.setDateOfFlight(dateOfFlight);

            LuggageHandler.handleLuggagePrompt(scanner, passenger); // New: Prompt for luggage handling

            SpecialNeedsAssistant assistant = new SpecialNeedsAssistant();
            assistant.specialNeedsAssistance(passenger);

            art.welcomeScreen(2);
            System.out.println("Here's your boarding pass for Passenger " + (i + 1) + ":");
            passenger.displayPassengerDetails();
        }
    }
}
