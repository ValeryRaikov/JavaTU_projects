class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Error in input for height or area" + super.getMessage();
    }
}