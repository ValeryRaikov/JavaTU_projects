class EventLimitExceededException extends Exception {
    public EventLimitExceededException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Exceeded limit: " + super.getMessage();
    }
}