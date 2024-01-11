import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    private static final Pattern usernamePattern = Pattern.compile("^([A-Za-z\\d]){8,16}$");
    private static final Pattern passwordPattern = Pattern.compile("^([A-Za-z\\d\\-_.]){8,16}$");
    private static final Pattern emailPattern = Pattern.compile("^[A-za-z\\d]+@[a-z\\-]{2,}.[a-z]{2,}$");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = sc.nextLine();

        if (!usernamePattern.matcher(username).matches())
            System.out.println("Invalid username!");

        System.out.println("Enter password:");
        String password = sc.nextLine();

        if (!passwordPattern.matcher(password).matches())
            System.out.println("Invalid password!");

        System.out.println("Enter email:");
        String email = sc.nextLine();

        if (!emailPattern.matcher(email).matches())
            System.out.println("Invalid email!");
    }
}
