import java.util.Random;

public class JourneyGenerator {
    private static final String[] LOCATIONS = {
        "New York", "London", "Tokyo", "Paris", "Sydney", "Dubai", "Los Angeles", "United States", "Canada", "Mexico",
        "Brazil", "Argentina", "Chile", "Colombia", "Peru", "Venezuela", "Ecuador", "Bolivia", "Uruguay", "Paraguay",
        "Panama", "Costa Rica", "Honduras", "Guatemala", "El Salvador", "Nicaragua", "Dominica", "New Zealand",
        "Belize", "Cuba", "Jamaica", "Haiti", "Dominican Republic", "Bahamas", "Trinidad and Tobago", "Barbados",
        "Saint Lucia", "Saint Vincent and the Grenadines", "Grenada", "Antigua and Barbuda", "Saint Kitts and Nevis",
        "Guyana", "Suriname", "Peru", "Bolivia", "Venezuela", "Guyana", "Suriname", "Paraguay", "Uruguay", "Brazil",
        "Chile", "Argentina", "Colombia", "Ecuador", "Peru", "Bolivia", "Venezuela", "Guyana", "Suriname", "Paraguay",
        "Uruguay", "Brazil", "Chile", "Argentina", "Colombia", "Ecuador", "Peru", "Bolivia", "Venezuela", "Guyana",
        "Suriname", "Paraguay", "Uruguay", "Brazil", "Chile", "Argentina", "Colombia", "Ecuador", "Peru", "Bolivia",
        "Venezuela", "Guyana", "Suriname", "Paraguay", "Uruguay", "Brazil", "Chile", "Argentina", "Colombia", "Ecuador",
        "Peru", "Bolivia", "Venezuela", "Guyana", "Suriname", "Paraguay", "Uruguay", "Brazil", "Chile", "Argentina",
        "Colombia", "Ecuador", "Peru", "Bolivia", "Venezuela", "Guyana", "Suriname", "Paraguay", "Uruguay", "Brazil",
        "Chile", "Argentina", "Colombia", "Ecuador", "Peru", "Bolivia", "Venezuela", "Guyana", "Suriname", "Paraguay",
        "Uruguay", "Brazil", "Chile", "Argentina", "Colombia", "Ecuador", "Peru", "Bolivia", "Venezuela", "Guyana",
        "Suriname", "Paraguay", "Uruguay", "Brazil", "Chile", "Argentina", "Colombia", "Ecuador", "Peru", "Bolivia",
        "Venezuela", "Guyana", "Suriname", "Paraguay", "Uruguay", "Brazil", "Chile", "Argentina", "Colombia", "Ecuador",
        "Peru", "Bolivia", "Venezuela", "Guyana", "Suriname", "Paraguay", "Uruguay", "Brazil", "Chile", "Argentina",
        "Colombia", "Ecuador", "Peru", "Bolivia", "Venezuela", "Guyana", "Suriname", "Paraguay", "Uruguay", "Brazil",
        "Chile", "Argentina", "Colombia", "Ecuador", "Peru", "Bolivia", "Venezuela", "Guyana", "Suriname", "Paraguay",
        "Uruguay", "Australia", "Malaysia"
    };

    // Method to generate random journey
    public static String generateJourney() {
        Random random = new Random();
        int fromIndex = random.nextInt(LOCATIONS.length);
        int toIndex = random.nextInt(LOCATIONS.length);
        while (toIndex == fromIndex || !LOCATIONS[fromIndex].equals("Malaysia") && !LOCATIONS[toIndex].equals("Malaysia")) {
            toIndex = random.nextInt(LOCATIONS.length);
        }
        return LOCATIONS[fromIndex] + " to " + LOCATIONS[toIndex];
    }
}
