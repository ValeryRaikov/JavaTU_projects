package RegularExamRetry;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    protected UserType getUserType() {
        return UserType.ADMIN;
    }

    @Override
    public String toString() {
        return "Admin{}" + super.toString();
    }
}
