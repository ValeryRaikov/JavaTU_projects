public class InvalidOperation extends Exception{
    public InvalidOperation(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Error occurred while trying to assign value to a product field!";
    }
}
