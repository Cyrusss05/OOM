import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class GroupPassengerHandler {
    public static void handleGroupPassenger(Scanner scanner) {
        Artwork art = new Artwork();
        Passenger passenger = new Passenger();
        // Handle group passenger check-in
        int numberOfPassengers;
        while (true) {
            System.out.print("Number of Passengers: ");
            try {
                numberOfPassengers = scanner.nextInt();
                if (numberOfPassengers <= 0) {
                    System.out.println("Number of passengers must be a positive integer.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numberOfPassengers; i++) {
            System.out.print("Enter First Name of Passenger " + (i + 1) + ": ");
            String firstName = scanner.nextLine(); // Read the entire line
            passenger.setFirstName(firstName.trim()); // Trim any leading/trailing whitespaces

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
            LocalDate dateOfFlight = AeroCheck.getValidDate(scanner, "Invalid Date. Please enter valid Date.");
            passenger.setDateOfFlight(dateOfFlight);

            boolean validInput = false;

            while (!validInput) {
                System.out.println("\t\tDo you want your luggage(s) to be handled? (Y/N)");
                char handleLuggage = scanner.next().charAt(0);
                switch (Character.toUpperCase(handleLuggage)) {
                    case 'Y': {
                        LuggageHandler.handleLuggage(scanner, passenger);
                        validInput = true;
                        break;
                    }
                    case 'N': {
                        validInput = true;
                        break;
                    }
                    default: {
                        System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                    }
                }
            }

            SpecialNeedsAssistant assistant = new SpecialNeedsAssistant();
            assistant.specialNeedsAssistance(passenger);
            validInput = true;

            art.welcomeScreen(2);
            System.out.println("Here's your boarding pass: ");
            passenger.displayPassengerDetails();
        }
    }
}
