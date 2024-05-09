import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AeroCheck{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Artwork art = new Artwork();
        int desiredOption;

        art.welcomeScreen(1);
        System.out.println("\n\t\t\t\t\t+++++++++++++ Welcome to AeroCheck AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.");
        desiredOption = displayMenuAndGetOption(scanner);
        switch (desiredOption) {
            case 1:
                handleSinglePassenger(scanner);
                break;
            case 2:
                handleGroupPassenger(scanner);
                break;
            case 0:
                System.out.println("\nExiting AeroCheck AirLines. Have a great day!\n");
                break;
            default:
                System.out.println("\nInvalid option. Please enter a valid option.\n");
                break;
        }

        scanner.close();
    }

    private static int displayMenuAndGetOption(Scanner scanner) {
        int desiredOption;
        while (true) {
            System.out.println("\n\n\t\t(0) Exit.");
            System.out.println("\t\t(1) Single Passenger Check-in.");
            System.out.println("\t\t(2) Group Passenger Check-in.\n\n");
            System.out.print("Enter the desired option:    ");
            try {
                desiredOption = scanner.nextInt();
                if (desiredOption < 0 || desiredOption > 2) {
                    System.out.print("\nERROR!! Please enter value between 0 - 2. Enter the value again.\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid value.\n");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return desiredOption;
    }

    private static void handleSinglePassenger(Scanner scanner) {
        Artwork art = new Artwork();
        // Handle single passenger check-in
        Passenger passenger = new Passenger();
            System.out.print("Enter Full Name: ");
            passenger.setName(scanner.next());
    
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
            LocalDate dateOfFlight = getValidDate(scanner, "Invalid Date. Please enter valid Date.");
            passenger.setDateOfFlight(dateOfFlight);
    
        passenger.displayPassengerDetails();
        System.out.println("\t\tDo you want your luggage(s) to be handled? (Y/N)");
        char handleLuggage = scanner.next().charAt(0);
        if (Character.toUpperCase(handleLuggage) == 'Y') {
            LuggageHandler.handleLuggage(scanner); // Call handleLuggage with scanner
        }

        System.out.println("Do you need special needs assistance? (Y/N): ");
        String specialNeeds = scanner.next();
        if (Character.toUpperCase(specialNeeds.charAt(0)) == 'Y') {
            specialNeedsAssistance();
            scanner.nextLine(); // Consume the newline character
        } else{
            return;
        }

        art.welcomeScreen(2);
    }

    private static void handleGroupPassenger(Scanner scanner) {
        Artwork art = new Artwork();
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
            Passenger passenger = new Passenger();
            System.out.print("Enter Full Name of Passenger " + (i + 1) + ": ");
            passenger.setName(scanner.nextLine());
    
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
            LocalDate dateOfFlight = getValidDate(scanner, "invalid");

            
            passenger.displayPassengerDetails();
    
            System.out.println("\t\tDo you want your luggage(s) to be handled? (Y/N)");
            char handleLuggage = scanner.next().charAt(0);
            if (Character.toUpperCase(handleLuggage) == 'Y') {
                LuggageHandler.handleLuggage(scanner); // Call handleLuggage with scanner
            }

            specialNeedsAssistance();
        }
        art.welcomeScreen(2);
    }

    private static void specialNeedsAssistance()
    {
        Artwork art = new Artwork();
        //  Handle special needs
        Scanner scanner = new Scanner(System.in);
        int snOptions;
        while (true) {
            System.out.println("\n\n\t\t(0) Return to check-in.");
            System.out.println("\t\t(1) Wheelchair Assistance.\n\n");
            System.out.print("Enter the desired option:    ");
            try {
                snOptions = scanner.nextInt();
                if (snOptions < 0 || snOptions > 1) {
                    System.out.print("\nERROR!! Please enter value between 0 - 1. Enter the value again.\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid value.\n");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        switch (snOptions) {

            case 1:
                art.welcomeScreen(3);
                System.out.println("Please wait patiently for our staff to locate to you.");
                break;
            case 0:
                break;
            default:
                System.out.println("\nInvalid option. Please enter a valid option.\n");
                break;
        }
    }

    private static LocalDate getValidDate(Scanner read, String errorMessage) {
        while (true) {
            String dateOfFlight = read.next();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                return LocalDate.parse(dateOfFlight, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(errorMessage);
            }
        }
    }
}
