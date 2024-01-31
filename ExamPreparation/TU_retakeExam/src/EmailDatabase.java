import java.util.HashMap;
import java.util.Map;

public class EmailDatabase {
    protected static Map<String, String> usersMap = new HashMap<>();
    protected static Map<String, Double> words = new HashMap<>();

    public Map<String, String> getUsersMap() {
        return usersMap;
    }

    public Map<String, Double> getWords() {
        return words;
    }

    public EmailDatabase() {
        initializeSpamWords();
    }

    //    Method for initializing spam words
    public void initializeSpamWords() {
        words.put("win", 0.9);
        words.put("free", 0.95);
        words.put("congratulations", 1.0);
//        add more spam words if needed
    }

//    Method for printing users email info
    public void printRegisteredUsers() {
        usersMap.forEach((email, pass) -> {
            StringBuilder maskedPassword = new StringBuilder();
            for (int i = 0; i < pass.length(); i++) {
                maskedPassword.append("*");
            }

            System.out.println(email + ": " + maskedPassword);
        });
    }
}
