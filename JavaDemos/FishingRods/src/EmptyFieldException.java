public class EmptyFieldException extends Exception{
    public EmptyFieldException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "This fishing rod field cannot be empty!";
    }
}
