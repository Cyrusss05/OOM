import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AeroCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int desiredOption;

        welcomeScreen(1);

        System.out.println("\n\t\t\t\t\t+++++++++++++ Welcome to AeroCheck AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.");
        while (true) {
            System.out.println("\n\n\t\t(0) Exit.");
            System.out.println("\t\t(1) Single Passenger Check-in.");
            System.out.println("\t\t(2) Group Passenger Check-in.");
            System.out.print("Enter the desired option:    ");
            try {
                desiredOption = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid value.\n");
                scanner.next(); // discard the invalid input
                continue;
            }

            if (desiredOption < 0 || desiredOption > 2) {
                System.out.print("\nERROR!! Please enter value between 0 - 2. Enter the value again.\n");
                continue;
            }

            // Process the desired option
            break;
        }

        if (desiredOption == 1) {
            singlePassengerCheckIn(scanner);
        } else if (desiredOption == 2) {
            groupPassengerCheckIn(scanner);
        }

        // Close the scanner to release system resources
        scanner.close();
    }

    private static void singlePassengerCheckIn(Scanner scanner) {
        System.out.print("\nEnter Full Name: ");
        String name = scanner.next();

        System.out.print("Age: ");
        int age = getValidInt(scanner, "Invalid age. Please enter a valid age.");

        System.out.print("Gender (M/F): ");
        char gender = getValidChar(scanner, "Invalid gender. Please enter M or F.");

        System.out.print("Date of Flight (dd/mm/yyyy): ");
        LocalDate dateOfFlight = getValidDate(scanner, "Invalid Date. Please enter valid Date.");

        System.out.println("\nSingle passenger details are as follows:\nName:\t" + name + "\nAge:\t" + age + " years old." + "\nGender:\t" + gender + "\nDate of Flight:\t" + dateOfFlight);

        System.out.println("\t\tDo you want your luggage(s) to be handled? (Y/N)");
        char handleLuggage = scanner.next().charAt(0);
        if (handleLuggage == 'Y' || handleLuggage == 'y') {
            handlingLuggage(scanner);
        }

        welcomeScreen(2);
    }

    private static void groupPassengerCheckIn(Scanner scanner) {
        System.out.print("Number of Passengers: ");
        int numberOfPassengers = getValidInt(scanner, "Invalid number of passengers. Please enter a valid number.");

        for (int i = 0; i < numberOfPassengers; i++) {
            System.out.print("Enter Full Name of Passenger " + (i + 1) + ": ");
            String name = scanner.next();

            System.out.print("Age of Passenger " + (i + 1) + ": ");
            int age = getValidInt(scanner, "Invalid age. Please enter a valid age.");

            System.out.print("Gender of Passenger " + (i + 1) + " (M/F): ");
            char gender = getValidChar(scanner, "Invalid gender. Please enter M or F.");

            System.out.print("Date of Flight (dd/mm/yyyy) of Passenger " + (i + 1) + ": ");
            LocalDate dateOfFlight = getValidDate(scanner, "Invalid Date. Please enter valid Date.");

            System.out.println("\nPassenger " + (i + 1) + " details are as follows:\nName:\t" + name + "\nAge:\t" + age + " years old." + "\nGender:\t" + gender + "\nDate of Flight:\t" + dateOfFlight);

            System.out.println("\t\tDo you want your luggage(s) to be handled? (Y/N)");
            char handleLuggage = scanner.next().charAt(0);
            if (handleLuggage == 'Y' || handleLuggage == 'y') {
                handlingLuggage(scanner);
            }
        }

        welcomeScreen(2);
    }

    private static int getValidInt(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.next(); // discard the invalid input
            }
        }
    }

    private static char getValidChar(Scanner scanner, String errorMessage) {
        while (true) {
            String input = scanner.next();
            if (input.length() != 1 || !(input.equalsIgnoreCase("M") || input.equalsIgnoreCase("F"))) {
                System.out.println(errorMessage);
            } else {
                return Character.toUpperCase(input.charAt(0));
            }
        }
    }

    private static LocalDate getValidDate(Scanner scanner, String errorMessage) {
        while (true) {
            String dateOfFlight = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                return LocalDate.parse(dateOfFlight, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(errorMessage);
            }
        }
    }

    private static void handlingLuggage(Scanner scanner) {
        System.out.println("\t\tPlease place your luggage(s) on the weighing scale");
        System.out.println("\t\tPress any key to Continue.");
        scanner.next();
        System.out.println("\t\tProccessing Weight...");
        System.out.println("\t\tPrinting baggage tag...");
        System.out.println("\t\tCompleted.\n");
        System.out.println("\t\tPress any key to Continue.");
        scanner.next();
        System.out.println();
    }

    static void welcomeScreen(int option) {
        String artWork = ""; // Initialize the artWork variable with an empty string


        if (option == 1) {
            artWork = """
                    888       888          888                                             
                    888   o   888          888                                            
                    888  d8b  888          888                                          
                    888 d888b 888  .d88b.  888  .d8888b .d88b.  88888b.d88b.   .d88b.     
                    888d88888b888 d8P  Y8b 888 d88P"   d88""88b 888 "888 "88b d8P  Y8b    
                    88888P Y88888 88888888 888 888     888  888 888  888  888 88888888    
                    8888P   Y8888 Y8b.     888 Y88b.   Y88..88P 888  888  888 Y8b.        
                    888P     Y888  "Y8888  888  "Y8888P "Y88P"  888  888  888  "Y8888                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                  \s
            """;
        }
        if (option == 2) {
            artWork = """
                    .d8888b.  888                        888            d8b                .d8888b.                                                       .d888          888      888 
                    d88P  Y88b 888                        888            Y8P               d88P  Y88b                                                     d88P"           888      888 
                    888    888 888                        888                              Y88b.                                                          888             888      888 
                    888        88888b.   .d88b.   .d8888b 888  888       888 88888b.        "Y888b.   888  888  .d8888b .d8888b .d88b.  .d8888b  .d8888b  888888 888  888 888      888 
                    888        888 "88b d8P  Y8b d88P"    888 .88P       888 888 "88b          "Y88b. 888  888 d88P"   d88P"   d8P  Y8b 88K      88K      888    888  888 888      888 
                    888    888 888  888 88888888 888      888888K 888888 888 888  888            "888 888  888 888     888     88888888 "Y8888b. "Y8888b. 888    888  888 888      Y8P 
                    Y88b  d88P 888  888 Y8b.     Y88b.    888 "88b       888 888  888      Y88b  d88P Y88b 888 Y88b.   Y88b.   Y8b.          X88      X88 888    Y88b 888 888      888 
                    "Y8888P"  888  888  "Y8888   "Y8888P 888  888       888 888  888       "Y8888P"   "Y88888  "Y8888P "Y8888P  "Y8888  88888P'  88888P' 888     "Y88888 888      888 
                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                    
            """;
        }
        System.out.println(artWork);
    }
}
