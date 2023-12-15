public class TicketingSystemDemo {
    public static void main(String[] args) {
        TicketingSystem ticketingSystem = new TicketingSystem();

        ticketingSystem.submitTicket("Issue 1");
        ticketingSystem.submitTicket("Issue 2");
        ticketingSystem.submitTicket("Issue 3");

        Thread support1 = new Thread(() -> {
            ticketingSystem.assignTicketToSupport();
            ticketingSystem.resolveTicket(1);
        });

        Thread support2 = new Thread(() -> {
            ticketingSystem.assignTicketToSupport();
            ticketingSystem.resolveTicket(2);
        });

        support1.start();
        support2.start();
    }
}