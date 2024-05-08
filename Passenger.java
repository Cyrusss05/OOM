import java.util.Scanner;

public class Passenger {
    private String name;
    private int age;
    private char gender;
    private long passportNumber;
    private String dateOfFlight;

    public void readPassengerDetails(Scanner scanner) {
        System.out.print("\nEnter Full Name: ");
        this.name = scanner.next();
        System.out.print("Age: ");
        this.age = scanner.nextInt();
        System.out.print("Gender (M/F): ");
        this.gender = scanner.next().charAt(0);
        System.out.print("Passport Number: ");
        this.passportNumber = scanner.nextLong();
        System.out.println("Date of Flight (dd/mm/yyyy): ");
        this.dateOfFlight = scanner.next();
    }

    public void displayPassengerDetails() {
        System.out.println("\nPassenger details are as follows:\nName:\t" + name + "\nAge:\t" + age + " years old." + "\nGender:\t" + gender + "\nPassport Number:\t" + passportNumber + "\nDate of Flight:\t" + dateOfFlight);
    }

    // Getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPassportNumber(long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }
}
