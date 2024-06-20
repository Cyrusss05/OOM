import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class SinglePassengerHandler {
    public static void handleSinglePassenger(Scanner scanner) {
        Artwork art = new Artwork();
        Passenger passenger = new Passenger();
        LuggageHandler luggageHandler = new LuggageHandler();
        // Handle single passenger check-in
        art.welcomeScreen(5);
        System.out.print("\nEnter First Name: ");
        passenger.setFirstName(scanner.next());

        System.out.print("Enter Last Name: ");
        passenger.setLastName(scanner.next());

        while (true) {
            System.out.print("Age: ");
            try {
                int age = scanner.nextInt();
                if (age <= 0 ) {
                    System.out.println("Age must be a positive integer");
                    continue;
                }
                if (age >= 150){
                    System.out.println("Your age is above 150 and irrational");
                        char restart0;
                        do {
                            System.out.println("Do you want to restart the check in(Y/N)?");
                            restart0 = scanner.next().charAt(0);
                            switch (Character.toUpperCase(restart0)) {
                                case 'Y':
                                    handleSinglePassenger(scanner); // Restart the process
                                    return;
                                case 'N':
                                    art.welcomeScreen(7);
                                    System.exit(0); // Exit the program
                                default:
                                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                            }
                        } while (true);
                }
                if (age < 18) {
                    char restart1;
                    do {
                        System.out.println("You are underage and can't check in our system.");
                        System.out.println("Do you want to restart (Y/N)?");
                        restart1 = scanner.next().charAt(0);
                        switch (Character.toUpperCase(restart1)) {
                            case 'Y':
                                handleSinglePassenger(scanner); // Restart the process
                                return;
                            case 'N':
                            art.welcomeScreen(7);
                                System.exit(0); // Exit the program
                            default:
                                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                        }
                    } while (true);
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

        System.out.print("Passport Number of Passenger: ");
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
        System.out.println("\nYou are flying from " + passenger.getJourney() );

         // Generate random seat number using RandomSeatGenerator class
         String seatNumber = RandomSeatGenerator.generateRandomSeatNumber();
         passenger.setSeatNumber(seatNumber);
         System.out.println("Your seat number is = " + seatNumber + "\n");
            

        System.out.print("Date of Flight (dd/mm/yyyy): ");
        LocalDate dateOfFlight = DateValidator.getValidDate(scanner, "Invalid Date. Please enter valid Date.");
        passenger.setDateOfFlight(dateOfFlight);
        
        luggageHandler.handleLuggagePrompt(scanner, passenger); // New: Prompt for luggage handling

        SpecialNeedsAssistant assistant = new SpecialNeedsAssistant();
        assistant.specialNeedsAssistance(passenger);
        
        art.welcomeScreen(2);
        System.out.println("Here's your boarding pass: ");
        passenger.displayPassengerDetails();
    }
}
