import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminPassengerHandler {

    protected static final String ADMIN_PASSWORD = "2379"; // Admin password
    private static int ageLimit = 150; // Default age limit

    public static void handleAdminPassenger(Scanner scanner) {
        // Prompt for admin password
        @SuppressWarnings("unused")
        int desiredOption;
        Artwork art = new Artwork();
        System.out.println("\nUsername = Staff Admin");
        System.out.print("Enter Admin Password: ");
        String password = scanner.next();

        // Check if password matches
        if (password.equals(ADMIN_PASSWORD)) {
            // Password correct, allow access to passenger input
            handlePassengerInput(scanner);
        } else {
            // Password incorrect, display error message and return to menu
            System.out.println("\nIncorrect password. Access denied. Do you want to try again or return to main menu ?");
            System.out.println("\n\n(0) Exit.");
            System.out.println("(1) Back to main menu");
            System.out.println("(2) Retry\n\n");
            System.out.print("Enter the desired option:    ");
            int ReTry = scanner.nextInt();

            switch (ReTry) {
                case 0:
                    art.welcomeScreen(7);
                    System.exit(0); // Exit the program
                    break;
                case 1:
                    System.out.println("Returning to main menu...\n\n\n");
                    desiredOption = MenuHandler.displayMenuAndGetOption(scanner);
                    break;
                case 2:
                    System.out.println("Retry=\n");
                    handleAdminPassenger(scanner); // Restart the process
                    break;
                default:
                    System.out.println("\nInvalid option. Please enter a valid option.\n");
                    handleAdminPassenger(scanner); // Restart the process
                    break;
            }
        }
    }

    private static void handlePassengerInput(Scanner scanner) {
        // Handle admin passenger check-in
        int numberOfPassengers;
        while (true) {
            System.out.print("\nNumber of Passengers: ");
            try {
                numberOfPassengers = scanner.nextInt(); // Read the entire line
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

            // Prompt for changing age limit only if it's more than 150
            

            while (true) {
                System.out.print("Age of Passenger " + (i + 1) + ": ");
                try {
                    int age = scanner.nextInt();
                    if (age <= 0) {
                        System.out.println("Age must be a positive integer");
                        continue;
                    }

                    if (age > 150) {
                        System.out.println("Your age is above " + ageLimit + " and irrational");
                        System.out.println("Do you want to change the age limit? (Y/N)");
                        char changeLimitChoice = scanner.next().charAt(0);

                        switch (Character.toUpperCase(changeLimitChoice)){
                            case 'Y':
                                System.out.print("Enter the new age limit: ");
                                age = scanner.nextInt();
                               break;
                                
                            case 'N':
                                char restart1;
                                System.out.println("You are underage and can't check in our system.");
                                System.out.println("Do you want to restart the check in(Y/N)?");
                                restart1 = scanner.next().charAt(0);
                                switch (Character.toUpperCase(restart1)) {
                                    case 'Y':
                                        handleAdminPassenger(scanner); // Restart the process
                                        return;
                                    case 'N':
                                        System.exit(0); // Exit the program
                                    default:
                                        System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                                    }
                        }
                        continue;
                    }
                    if (age <= 18) {
                        char restart1;
                        do {
                            System.out.println("You are underage and can't check in our system.");
                            System.out.println("Do you want to restart the check in(Y/N)?");
                            restart1 = scanner.next().charAt(0);
                            switch (Character.toUpperCase(restart1)) {
                                case 'Y':
                                    handleAdminPassenger(scanner); // Restart the process
                                    return;
                                case 'N':
                                    System.exit(0); // Exit the program
                                default:
                                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                            }
                        } while (true);
                    }
                    
                    else{
                        passenger.setAge(age);
                        break;
                    }
                } 
                
                catch (InputMismatchException e) {
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
            String passportNumber;
            while (true) {
                passportNumber = scanner.next();
                if (passportNumber.length() != 8) {
                    System.out.println("Passport number must be exactly 8 characters long. Please try again.");
                    continue;
                }
                break;
            }
            passenger.setPassportNumber(passportNumber);

            System.out.print("Enter Online Booking Number Reference: ");
            String bookingNumber = scanner.next();
            passenger.setBookingNumber(bookingNumber);
            passenger.setJourney(JourneyGenerator.generateJourney());
            System.out.println("you are flying from " + passenger.getJourney());

            // Generate random seat number using RandomSeatGenerator class
            String seatNumber = RandomSeatGenerator.generateRandomSeatNumber();
            passenger.setSeatNumber(seatNumber);
            System.out.println("Your seat number is = " + seatNumber + "\n");

            System.out.print("Date of Flight (dd/mm/yyyy) of Passenger " + (i + 1) + ": ");
            LocalDate dateOfFlight = DateValidator.getValidDate(scanner, "Invalid Date. Please enter valid Date.");
            passenger.setDateOfFlight(dateOfFlight);

            LuggageHandler.handleLuggagePrompt(scanner, passenger); // New: Prompt for luggage handling

            SpecialNeedsAssistant assistant = new SpecialNeedsAssistant();
            assistant.specialNeedsAssistance(passenger);

            System.out.println("Here's your boarding pass for Passenger " + (i + 1) + ":");
            passenger.displayPassengerDetails();
        }
    }
}
