import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1st exercise
        System.out.println("Enter your phone number: ");
        String phoneNumber = sc.nextLine();

        Pattern pattern = Pattern.compile("^\\+359\\d{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches())
            System.out.println("Phone number: " + phoneNumber + " is valid.");
        else
            System.out.println("Invalid phone number!");

        // 2nd exercise
        String text =
                "Java SE lets you develop and deploy Java applications on desktops and servers. " +
                        "Java SE and component technologies offer the rich user interface, performance, versatility, " +
                        "portability, and security that today's applications require.";

        Pattern pattern2 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(text);

        int matches = 0;
        while (matcher2.find()) {
            matches++;
        }

        System.out.println("Word 'java' is encountered " + matches + " times.");
    }
}
