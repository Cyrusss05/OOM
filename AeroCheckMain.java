import java.util.Scanner;

public class AeroCheckMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Artwork art = new Artwork();
        int desiredOption;
        art.welcomeScreen(1);
        
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
    }
}
