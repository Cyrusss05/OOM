import java.util.Random;

public class JourneyGenerator {
    private static final String[] LOCATIONS = {"New York", "London", "Tokyo", "Paris", "Sydney", "Dubai", "Los Angeles"};

    // Method to generate random journey
    public static String generateJourney() {
        Random random = new Random();
        int fromIndex = random.nextInt(LOCATIONS.length);
        int toIndex = random.nextInt(LOCATIONS.length);
        while (toIndex == fromIndex) {
            toIndex = random.nextInt(LOCATIONS.length);
        }
        return LOCATIONS[fromIndex] + " to " + LOCATIONS[toIndex];
    }
}
