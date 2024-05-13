import java.util.Random;

public class RandomSeatGenerator {
    // Method to generate random seat number
    public static String generateRandomSeatNumber() {
        Random rand = new Random();
        char row = (char) (rand.nextInt(26) + 'A'); // Random row (A-Z)
        int seat = rand.nextInt(10) + 1; // Random seat (1-10)
        return row + Integer.toString(seat);
    }
}
