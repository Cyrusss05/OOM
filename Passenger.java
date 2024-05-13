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
    private String baggageTag;
    private String journey;
    private String bookingNumber;
    private String seatNumber;




    // Getter and setter 
    public String getAssist() {
        return specialNeedsAssistance ? "Required" : "Not Required";
    }

    // Constructor
    public Passenger() {
        this.seatNumber = "";
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBaggageTag() {
        return baggageTag ;
    }

    public void displayPassengerDetails() {
        
        PassengerDetailsFrame frame = new PassengerDetailsFrame(this);
        frame.setVisible(true);
    }

    public String getJourney() {
        return journey;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

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

    public void setBaggageTag(String baggageTag) {
        this.baggageTag = baggageTag;
    }

    public void setJourney(String journey) {
        this.journey = journey;
    }

    
}
