import java.util.InputMismatchException;
import java.util.Scanner;

public class SpecialNeedsAssistant {

    public void specialNeedsAssistance() {
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
        scanner.close();
    }
}
