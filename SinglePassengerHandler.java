import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class SinglePassengerHandler {
    public static void handleSinglePassenger(Scanner scanner) {
        Artwork art = new Artwork();
        Passenger passenger = new Passenger();
        // Handle single passenger check-in
        System.out.println("\n");
        System.out.println("\n+++++++++++++ Single Passenger Check-in +++++++++++++");
        System.out.print("\nEnter First Name: ");
        passenger.setFirstName(scanner.next());

        System.out.print("Enter Last Name: ");
        passenger.setLastName(scanner.next());

        while (true) {
            System.out.print("Age: ");
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

        System.out.print("Gender (M/F): ");
        String genderInput = scanner.nextLine().toUpperCase();
        while (!genderInput.equals("M") && !genderInput.equals("F")) {
            System.out.println("Invalid input. Please enter M or F.");
            System.out.print("Gender of Passenger (M/F): ");
            genderInput = scanner.nextLine().toUpperCase();
        }
        passenger.setGender(genderInput.charAt(0));

        System.out.print("Passport Number: ");
        String passportNumber = scanner.next();
        passenger.setPassportNumber(passportNumber);
        System.out.print("Date of Flight (dd/mm/yyyy): ");
        LocalDate dateOfFlight = DateValidator.getValidDate(scanner, "Invalid Date. Please enter valid Date.");
        passenger.setDateOfFlight(dateOfFlight);
        
        LuggageHandler.handleLuggagePrompt(scanner, passenger); // New: Prompt for luggage handling

        SpecialNeedsAssistant assistant = new SpecialNeedsAssistant();
        assistant.specialNeedsAssistance(passenger);
        
        art.welcomeScreen(2);
        System.out.println("Here's your boarding pass: ");
        passenger.displayPassengerDetails();
    }
}
