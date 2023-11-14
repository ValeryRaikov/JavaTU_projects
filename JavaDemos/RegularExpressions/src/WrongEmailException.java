public class WrongEmailException extends Exception {
    public WrongEmailException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Email mistaken!";
    }
}