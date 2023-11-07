public class KeyNotFoundException extends Exception {
    public KeyNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Entered promo code is invalid!";
    }
}