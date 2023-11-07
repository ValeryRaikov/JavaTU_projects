public class InvalidFieldException extends Exception{
    public InvalidFieldException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "This fishing rod field is mistaken!";
    }
}
