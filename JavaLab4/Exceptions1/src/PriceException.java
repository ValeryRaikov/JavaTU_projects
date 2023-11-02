public class PriceException extends Exception {
    public PriceException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Error in the price: " + super.getMessage();
    }
}