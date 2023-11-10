class WrongPhoneNumberException extends Exception {
    public WrongPhoneNumberException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Error in creating User -> phone number mistaken!";
    }
}