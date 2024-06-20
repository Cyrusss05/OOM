import java.util.Scanner;

public class SpecialNeedsAssistant {

    public void specialNeedsAssistance(Passenger passenger) {
        Artwork art = new Artwork();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Prompt user for special needs assistance
        System.out.println("Do you require special need wheel chair assistance? (Y/N)");
        char snOption = scanner.next().charAt(0);

        switch (Character.toUpperCase(snOption)) {
            case 'Y':
                art.welcomeScreen(3);
                System.out.println("Please wait patiently for our staff to locate to you.");
                passenger.setSpecialNeedsAssistance(true);
                break;
            case 'N':
                break;
            default:
                System.out.println("\nInvalid option. Please enter a valid option.\n");
                break;
        }
    }
}
