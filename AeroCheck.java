import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AeroCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int desiredOption;

        welcomeScreen(1);
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
            System.out.println("\t\t(2) Group Passenger Check-in.");
            System.out.println("\t\t(3) Special Needs Assistance.\n\n");
            System.out.print("Enter the desired option:    ");
            try {
                desiredOption = scanner.nextInt();
                if (desiredOption < 0 || desiredOption > 3) {
                    System.out.print("\nERROR!! Please enter value between 0 - 3. Enter the value again.\n");
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
        welcomeScreen(2);
    }

    private static void handleGroupPassenger(Scanner scanner) {
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
            String dateOfFlight = scanner.next();
            passenger.setDateOfFlight(dateOfFlight);
    
            passenger.displayPassengerDetails();
    
            System.out.println("\t\tDo you want your luggage(s) to be handled? (Y/N)");
            char handleLuggage = scanner.next().charAt(0);
            if (Character.toUpperCase(handleLuggage) == 'Y') {
                LuggageHandler.handleLuggage(scanner); // Call handleLuggage with scanner
            }
        }
        welcomeScreen(2);
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
    
    static void welcomeScreen(int option) {
        String artWork;

        if (option == 1) {
            artWork = """
                888       888          888                                             888                       d8888                           .d8888b.  888                        888     
                888   o   888          888                                             888                      d88888                          d88P  Y88b 888                        888     
                888  d8b  888          888                                             888                     d88P888                          888    888 888                        888     
                888 d888b 888  .d88b.  888  .d8888b .d88b.  88888b.d88b.   .d88b.      888888 .d88b.          d88P 888  .d88b.  888d888 .d88b.  888        88888b.   .d88b.   .d8888b 888  888
                888d88888b888 d8P  Y8b 888 d88P"   d88""88b 888 "888 "88b d8P  Y8b     888   d88""88b        d88P  888 d8P  Y8b 888P"  d88""88b 888        888 "88b d8P  Y8b d88P"    888 .88P
                88888P Y88888 88888888 888 888     888  888 888  888  888 88888888     888   888  888       d88P   888 88888888 888    888  888 888    888 888  888 88888888 888      888888K 
                8888P   Y8888 Y8b.     888 Y88b.   Y88..88P 888  888  888 Y8b.         Y88b. Y88..88P      d8888888888 Y8b.     888    Y88..88P Y88b  d88P 888  888 Y8b.     Y88b.    888 "88b
                888P     Y888  "Y8888  888  "Y8888P "Y88P"  888  888  888  "Y8888       "Y888 "Y88P"      d88P     888  "Y8888  888     "Y88P"   "Y8888P"  888  888  "Y8888   "Y8888P 888  888
                            """;
        }
        else {
            artWork ="""

 .d8888b.  888                        888            d8b                .d8888b.                                                       .d888          888      888 
d88P  Y88b 888                        888            Y8P               d88P  Y88b                                                     d88P"           888      888 
888    888 888                        888                              Y88b.                                                          888             888      888 
888        88888b.   .d88b.   .d8888b 888  888       888 88888b.        "Y888b.   888  888  .d8888b .d8888b .d88b.  .d8888b  .d8888b  888888 888  888 888      888 
888        888 "88b d8P  Y8b d88P"    888 .88P       888 888 "88b          "Y88b. 888  888 d88P"   d88P"   d8P  Y8b 88K      88K      888    888  888 888      888 
888    888 888  888 88888888 888      888888K 888888 888 888  888            "888 888  888 888     888     88888888 "Y8888b. "Y8888b. 888    888  888 888      Y8P 
Y88b  d88P 888  888 Y8b.     Y88b.    888 "88b       888 888  888      Y88b  d88P Y88b 888 Y88b.   Y88b.   Y8b.          X88      X88 888    Y88b 888 888       "  
 "Y8888P"  888  888  "Y8888   "Y8888P 888  888       888 888  888       "Y8888P"   "Y88888  "Y8888P "Y8888P "Y8888   88888P'  88888P' 888     "Y88888 888      888 
                                                                                                                                                                   
                                                                                                                                                                   
                                                                                                                                                                   

                    """;
        }
        System.out.println(artWork);
    }
}
