import java.util.ArrayList;
import java.util.List;

class TicketingSystem {
    private final List<Ticket> inbox;
    private final List<Ticket> resolvedTickets;

    public TicketingSystem() {
        this.inbox = new ArrayList<>();
        this.resolvedTickets = new ArrayList<>();
    }

    public synchronized void submitTicket(String message) {
        Ticket newTicket = new Ticket(message);
        inbox.add(newTicket);
        System.out.println("New Ticket #" + newTicket.getTicketNumber() + " submitted.");
    }

    public synchronized List<Ticket> getInbox() {
        return new ArrayList<>(inbox);
    }

    public synchronized List<Ticket> getResolvedTickets() {
        return new ArrayList<>(resolvedTickets);
    }

    public synchronized void assignTicketToSupport() {
        for (Ticket ticket : inbox) {
            if (!ticket.isAssigned()) {
                ticket.assign();
                System.out.println("Ticket #" + ticket.getTicketNumber() + " assigned to support.");
                break;
            }
        }
    }

    public synchronized void resolveTicket(int ticketNumber) {
        for (Ticket ticket : inbox) {
            if (ticket.getTicketNumber() == ticketNumber) {
                ticket.resolve();
                resolvedTickets.add(ticket);
                inbox.remove(ticket);
                System.out.println("Ticket #" + ticketNumber + " resolved.");
                break;
            }
        }
    }
}