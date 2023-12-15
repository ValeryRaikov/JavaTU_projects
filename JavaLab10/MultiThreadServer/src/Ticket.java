class Ticket {
    private static int nextTicketNumber = 1;

    private final int ticketNumber;
    private final String message;
    private boolean assigned;
    private boolean resolved;

    public Ticket(String message) {
        this.ticketNumber = nextTicketNumber++;
        this.message = message;
        this.assigned = false;
        this.resolved = false;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getMessage() {
        return message;
    }

    public synchronized boolean isAssigned() {
        return assigned;
    }

    public synchronized void assign() {
        this.assigned = true;
    }

    public synchronized boolean isResolved() {
        return resolved;
    }

    public synchronized void resolve() {
        this.resolved = true;
    }
}