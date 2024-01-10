package RegularExamRetry;

import java.util.regex.Pattern;

public class UserFactory {
    private static final Pattern facultyNumberPattern = Pattern.compile("^\\d{9}$");

    private static final Pattern EGNPattern = Pattern.compile("^\\d{10}$");

    private static final Pattern emailPattern = Pattern.compile("[a-z]+@tu-sofia.bg");

    public static User createUser(String username, String password, UserType userType) throws CredentialsException {
        switch (userType) {
            case ADMIN:
                return new Admin(username, password);
            case STUDENT:
                if(!facultyNumberPattern.matcher(username).matches())
                    throw new CredentialsException();
                if(!EGNPattern.matcher(password).matches())
                    throw new CredentialsException();

                return new Student(username, password);
            case TEACHER:
                if(!emailPattern.matcher(password).matches())
                    throw new CredentialsException();

                return new Teacher(username, password);
            default:
                System.out.println("Invalid user type!");
                return null;
        }
    }
}
