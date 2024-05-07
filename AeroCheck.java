/*
group assignment for Java OOM COURSEWORK

1) UJJAYRAJ A/L B RAJ MANI RAO = 23092232
2) CHEN WEI HANG = 23103427
3) CHOO TING FENG=23064140 
4) Aakash Pai = 23047350
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AeroCheck
{
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int desiredOption;

            welcomeScreen(1);
            System.out.println("\n\t\t\t\t\t+++++++++++++ Welcome to AeroCheck AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.");
            while (true) {
            System.out.println("\n\n\t\t(0) Exit.");
            System.out.println("\t\t(1) Single Passenger Check-in.");
            System.out.println("\t\t(2) Group Passenger Check-in.");
            System.out.print("Enter the desired option:    ");
            try {
                desiredOption = read.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid value.\n");
                read.next(); // discard the invalid input
                continue;
            }

            if (desiredOption < 0 || desiredOption > 2) {
                System.out.print("\nERROR!! Please enter value between 0 - 2. Enter the value again.\n");
                continue;
            }

            // Process the desired option
            break;
        }

        do {
            Scanner read1 = new Scanner(System.in);

            if (desiredOption == 1) {
                
                System.out.print("\nEnter Full Name: ");
                String name = read1.nextLine();
                
                System.out.print("Age: ");
                int age = getValidInt(read1, "Invalid age. Please enter a valid age.");

                System.out.print("Gender (M/F): ");
                char gender = getValidChar(read1, "Invalid gender. Please enter M or F.");

                System.out.print("Passport Number: ");
                long passNum = getValidLong(read1, "Invalid Passport number. Please enter a valid Passport number.");

                System.out.println("Date of Flight (dd/mm/yyyy): ");
                LocalDate dateOfFlight = getValidDate(read1, "Invalid Date. Please enter valid Date.");

                System.out.println("\nSingle passenger details are as follows:\nName:\t" + name + "\nAge:\t" + age + " years old." + "\nGender:\t" + gender + "\nDate of Flight:\t" + dateOfFlight);

                System.out.println("\t\tDo you want your luggage(s) to be handled? (Y/N)");
                char handleLuggage = read1.next().charAt(0);
                while (handleLuggage == 'Y'  || handleLuggage == 'y') {
                    handlingLuggage();
                    break;
                }
                welcomeScreen(2);
                return;
            }
            
            if (desiredOption == 2) {    
            System.out.print("Number of Passengers: ");
            int numberOfPassengers = getValidInt(read, "Invalid number of passengers. Please enter a valid number.");
    
                for (int i = 0; i < numberOfPassengers; i++) {
                    System.out.print("Enter Full Name of Passenger " + (i + 1) + ": ");
                    String name = read.next();
        
                    System.out.print("Age of Passenger " + (i + 1) + ": ");
                    int age = getValidInt(read, "Invalid age. Please enter a valid age.");
        
                    System.out.print("Gender of Passenger " + (i + 1) + " (M/F): ");
                    char gender = getValidChar(read, "Invalid gender. Please enter M or F.");
        
                    System.out.print("Passport Number of Passenger " + (i + 1) + ": ");
                    long passportNumber = getValidLong(read, "Invalid passport number. Please enter a valid passport number.");
        
                    System.out.print("Date of Flight (dd/mm/yyyy) of Passenger " + (i + 1) + ": ");
                    String dateOfFlight = read.next();
        
                    System.out.println("\nPassenger " + (i + 1) + " details are as follows:\nName:\t" + name + "\nAge:\t" + age + " years old." + "\nGender:\t" + gender + "\nDate of Flight(yyyy/dd/mm):\t" + dateOfFlight);
                
                    char handleLuggage = read1.next().charAt(0);
                    while (handleLuggage == 'Y'  || handleLuggage == 'y') {
                    handlingLuggage();
                    break;
                }
                }
                break;
            }
        } 
        while (desiredOption != 0);
        return;
    }

    private static int getValidInt(Scanner read, String errorMessage) {
        while (true) {
            try {
                return read.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                read.next(); // discard the invalid input
            }
        }
    }

    private static char getValidChar(Scanner read, String errorMessage) {
        while (true) {
            String input = read.next();
            if (input.length() != 1) {
                System.out.println(errorMessage);
                continue;
            }
            char c = input.charAt(0);
            if (c != 'M' && c != 'F' && c != 'm' && c != 'f') {
                System.out.println(errorMessage);
                continue;
            }
            return Character.toUpperCase(c);
        }
    }

    private static long getValidLong(Scanner read, String errorMessage) {
        while (true) {
            try {
                return read.nextLong();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                read.next(); // discard the invalid input
            }
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

    private static void handlingLuggage(){
        Scanner read1 = new Scanner(System.in);
        System.out.println("\t\tPlease place your luggage(s) on the weighing scale");
        System.out.println("\t\tPress any key to Continue.");
        read1.next();
        System.out.println("\t\tProccessing Weight...");
        System.out.println("\t\tPrinting baggage tag...");
        System.out.println("\t\tCompleted.\n");
        System.out.println("\t\tPress any key to Continue.");
        read1.next();
        System.out.println();
    }

    static void welcomeScreen(int option) {
        String artWork;

        if (option == 1) {
            artWork = """

888       888          888                                              888                        d8888                           .d8888b.  888                        888                  d8888 d8b         888 d8b                            
888   o   888          888                                              888                       d88888                          d88P  Y88b 888                        888                 d88888 Y8P         888 Y8P                            
888  d8b  888          888                                              888                      d88P888                          888    888 888                        888                d88P888             888                                
888 d888b 888  .d88b.  888  .d8888b .d88b.  88888b.d88b.   .d88b.       888888 .d88b.           d88P 888  .d88b.  888d888 .d88b.  888        88888b.   .d88b.   .d8888b 888  888          d88P 888 888 888d888 888 888 88888b.   .d88b.  .d8888b  
888d88888b888 d8P  Y8b 888 d88P"   d88""88b 888 "888 "88b d8P  Y8b      888   d88""88b         d88P  888 d8P  Y8b 888P"  d88""88b 888        888 "88b d8P  Y8b d88P"    888 .88P         d88P  888 888 888P"   888 888 888 "88b d8P  Y8b 88K      
88888P Y88888 88888888 888 888     888  888 888  888  888 88888888      888   888  888        d88P   888 88888888 888    888  888 888    888 888  888 88888888 888      888888K         d88P   888 888 888     888 888 888  888 88888888 "Y8888b. 
8888P   Y8888 Y8b.     888 Y88b.   Y88..88P 888  888  888 Y8b.          Y88b. Y88..88P       d8888888888 Y8b.     888    Y88..88P Y88b  d88P 888  888 Y8b.     Y88b.    888 "88b       d8888888888 888 888     888 888 888  888 Y8b.          X88 
888P     Y888  "Y8888  888  "Y8888P "Y88P"  888  888  888  "Y8888        "Y888 "Y88P"       d88P     888  "Y8888  888     "Y88P"   "Y8888P"  888  888  "Y8888   "Y8888P 888  888      d88P     888 888 888     888 888 888  888  "Y8888   88888P' 
                                                                                                                                                                                                                                                  
                                                                                                                                                                                                                                                  
                                                                                                                                                                                                                                                  
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
Y88b  d88P 888  888 Y8b.     Y88b.    888 "88b       888 888  888      Y88b  d88P Y88b 888 Y88b.   Y88b.   Y8b.          X88      X88 888    Y88b 888 888       "  
 "Y8888P"  888  888  "Y8888   "Y8888P 888  888       888 888  888       "Y8888P"   "Y88888  "Y8888P "Y8888P "Y8888   88888P'  88888P' 888     "Y88888 888      888 
                                                                                                                                                                   
                                                                                                                                                                   
                                                                                                                                                                   

                    """;
        System.out.println(artWork);
        }

    }
}



