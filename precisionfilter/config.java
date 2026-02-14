import io.github.cdimascio.dotenv.Dotenv;

public class config {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getGmailAPI() {
        return dotenv.get("GOOGLE_BOOKS_API_KEY");
    }

    public static String getBackBoardAPI() {
        return dotenv.get("BACKBOARD_API_KEY");
    }
}