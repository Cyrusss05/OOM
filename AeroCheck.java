import java.util.Scanner;

public class AeroCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Artwork art = new Artwork();
        int desiredOption;
        art.welcomeScreen(1);
        System.out.println("\n\t\t\t\t\t+++++++++++++ Welcome to AeroCheck AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.");

        desiredOption = MenuHandler.displayMenuAndGetOption(scanner);
        
        switch (desiredOption) {
            case 1:
                SinglePassengerHandler.handleSinglePassenger(scanner);
                break;
            case 2:
                GroupPassengerHandler.handleGroupPassenger(scanner);
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
}
