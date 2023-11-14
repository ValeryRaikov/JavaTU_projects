public class WrongUsernameException extends Exception {
    public WrongUsernameException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Username mistaken!";
    }
}
