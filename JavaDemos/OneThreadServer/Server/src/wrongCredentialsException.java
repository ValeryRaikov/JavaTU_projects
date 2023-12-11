public class wrongCredentialsException extends Exception{
    public wrongCredentialsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Username or password mismatch program patterns... Try again!";
    }
}
