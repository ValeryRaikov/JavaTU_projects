import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws WrongUsernameException, WrongPhoneNumberException, WrongEmailException, WrongPasswordException {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String[]> users = new HashMap<>();

        while (true) {
            System.out.println("Choose your option:\n1. Login\n2. Sign up\n3. Exit\n");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            User currentUser = null;

            switch (choice) {
                case 1:
                    // Login
                    currentUser = new User().loginUser(scanner, users);
                    if (currentUser != null) {
                        System.out.println("Welcome back, " + currentUser.getUsername() + "!");
                    }
                    break;

                case 2:
                    currentUser = new User().signUpUser(scanner, users);
                    if (currentUser != null) {
                        System.out.println("Welcome, " + currentUser.getUsername() + "!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    User.showUsers(users);

                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
