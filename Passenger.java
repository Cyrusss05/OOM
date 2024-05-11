import java.time.LocalDate;

public class Passenger {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private String passportNumber;
    private LocalDate dateOfFlight;
    private double luggageWeight;
    private boolean specialNeedsAssistance;

    // Getter and setter for assist
    public String getAssist() {
        return specialNeedsAssistance ? "Required" : "Not Required";
    }


    public void displayPassengerDetails() {
        // Check if specialNeedsAssistance is true or false and set assist accordingly
        String assist = specialNeedsAssistance ? "Required" : "Not Required";

        System.out.println("___________________________________________________________________________________________________________________________________________________");
        System.out.println("| Passenger Details");
        System.out.println("| Full Name: " + firstName + " " + lastName);
        System.out.println("| Age: " + age + " years old.");
        System.out.println("| Gender: " + gender);
        System.out.println("| Passport Number: " + passportNumber);
        System.out.println("| Date of Flight (yyyy/mm/dd): " + dateOfFlight);
        System.out.println("| Luggage Weight: " + luggageWeight + " Kg");
        System.out.println("| Special Needs Assistance: " + assist);
        System.out.println("|__________________________________________________________________________________________________________________________________________________");
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public LocalDate getDateOfFlight() {
        return dateOfFlight;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public boolean isSpecialNeedsAssistance() {
        return specialNeedsAssistance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setDateOfFlight(LocalDate dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public void setSpecialNeedsAssistance(boolean specialNeedsAssistance) {
        this.specialNeedsAssistance = specialNeedsAssistance;
    }
}
