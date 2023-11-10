class WrongUserException extends Exception {
    public WrongUserException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Error in creating User -> username or password mistaken!";
    }
}