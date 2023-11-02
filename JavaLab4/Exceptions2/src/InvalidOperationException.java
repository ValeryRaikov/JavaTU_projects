class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Invalid operation: " + super.getMessage();
    }
}