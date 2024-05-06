public class UserInterface {
    public static void displayWelcomeScreen(int option) {
        String artWork = "";

        if (option == 1) {
            artWork = """
            // Original ASCII Artwork for welcome screen option 1
            """;
        } else if (option == 2) {
            artWork = """
            // Original ASCII Artwork for welcome screen option 2
            """;
        }

        System.out.println(artWork);
    }
}
