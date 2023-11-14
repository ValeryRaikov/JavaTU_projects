import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class User implements ValidateUsername, ValidatePassword, ValidateEmail, ValidatePhoneNumber {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    public User(String username, String password, String email, String phoneNumber)
            throws WrongUsernameException, WrongPasswordException, WrongEmailException, WrongPhoneNumberException {

        try {
            ValidateUsername.ValidateUsername(username);
            ValidatePassword.ValidatePassword(password);
            ValidateEmail.ValidateEmail(email);
            ValidatePhoneNumber.ValidatePhoneNumber(phoneNumber);
        }
        catch (WrongUsernameException | WrongPasswordException | WrongEmailException | WrongPhoneNumberException e) {
            System.err.println("Oops..." + e.getMessage());
        }

        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newUsername) throws WrongUsernameException {
        ValidateUsername.ValidateUsername(newUsername);

        this.username = newUsername;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newPassword) throws WrongPasswordException {
        ValidatePassword.ValidatePassword(newPassword);

        this.password = newPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) throws WrongEmailException {
        ValidateEmail.ValidateEmail(newEmail);

        this.email = newEmail;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String newPhoneNumber) throws WrongPhoneNumberException {
        ValidatePhoneNumber.ValidatePhoneNumber(newPhoneNumber);

        this.phoneNumber = newPhoneNumber;
    }

    public User loginUser(Scanner sc, HashMap<String, String[]> users) {
        System.out.println("Hello there!");

        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        if (users.containsKey(username)) {
            String[] storedInfo = users.get(username);
            String storedPassword = storedInfo[0];

            if (storedPassword.equals(password)) {
                System.out.println("Login successful!");

                try {
                    return new User(username, storedPassword, storedInfo[1], storedInfo[2]);
                }
                catch (WrongUsernameException | WrongPasswordException | WrongEmailException | WrongPhoneNumberException e) {
                    System.err.println("Oops..." + e.getMessage());
                }
            }
            System.out.println("Incorrect password. Login failed.");
            return null;
        }
        else {
            System.out.println("Username not found. Login failed.");
        }
        return null;
    }

    public User signUpUser(Scanner sc, HashMap<String, String[]> users) {
        System.out.println("Welcome to the sign-up process!");

        System.out.print("Enter a new username: ");
        String newUsername = sc.nextLine();

        if (users.containsKey(newUsername)) {
            System.out.println("Username already exists. Please choose a different username.");
            return null;
        }

        System.out.print("Enter a password: ");
        String newPassword = sc.nextLine();
        System.out.print("Enter an email: ");
        String newEmail = sc.nextLine();
        System.out.print("Enter a phone number: ");
        String newPhoneNumber = sc.nextLine();

        try {
            User newUser = new User(newUsername, newPassword, newEmail, newPhoneNumber);
            users.put(newUsername, new String[]{newPassword, newEmail, newPhoneNumber});

            System.out.println("Sign-up successful!");
            return newUser;

        } catch (WrongUsernameException | WrongPasswordException | WrongEmailException | WrongPhoneNumberException e) {
            System.err.println("Oops..." + e.getMessage());
            return null;
        }
    }

    public static void showUsers(HashMap<String, String[]> users) {
        System.out.println("Users in the system:");

        Iterator<HashMap.Entry<String, String[]>> iterator = users.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, String[]> entry = iterator.next();
            String username = entry.getKey();
            String[] userInfo = entry.getValue();

            System.out.println("Username: " + username);
            System.out.println("Password: " + userInfo[0]);
            System.out.println("Email: " + userInfo[1]);
            System.out.println("Phone Number: " + userInfo[2]);
            System.out.println("------------");
        }
    }

}