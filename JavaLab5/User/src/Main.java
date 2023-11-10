import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] users = new User[5];

        int index = 0;
        while (index < 5) {
            System.out.println("Choose one of the following options:");
            System.out.println("1. Registration:");
            System.out.println("2. Login:");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter username: ");
                        String newUsername = sc.next();
                        System.out.println("Enter password: ");
                        String newPassword = sc.next();
                        System.out.println("Enter same password again: ");
                        String repeatPassword = sc.next();

                        if (!newPassword.equals(repeatPassword)) {
                            System.out.println("Passwords are not equal.");
                            break;
                        }

                        System.out.println("Enter phone number: ");
                        String newPhoneNumber = sc.next();

                        User newUser = new User(newUsername, newPassword, newPhoneNumber);
                        users[index] = newUser;
                        System.out.println("Successful registration!");
                        index++;
                    }
                    catch (WrongUserException | WrongPhoneNumberException e) {
                        System.err.println("Error occurred: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Enter username: ");
                    String enteredUsername = sc.next();
                    System.out.println("Enter password: ");
                    String enteredPassword = sc.next();

                    boolean isLoggedIn = false;
                    for (User user : users) {
                        if (user != null && user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
                            isLoggedIn = true;
                            break;
                        }
                    }

                    if (isLoggedIn) {
                        System.out.println("Successful login!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
                    break;
            }
        }
    }
}