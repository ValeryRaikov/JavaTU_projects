public class PowerException extends Exception {
    public PowerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Error in the power: " + super.getMessage();
    }
}