public class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Password mistaken!";
    }
}