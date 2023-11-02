import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventLog eventLog = new EventLog();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add current event");
            System.out.println("2. Delete current event");
            System.out.println("3. Edit current event");
            System.out.println("4. Print events");
            System.out.println("5. Exit");
            System.out.println();

            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter current event: ");
                    String event = sc.nextLine();
                    try {
                        eventLog.addEvent(event);
                        System.out.println("Successfully added event.");
                    } catch (EventLimitExceededException e) {
                        System.err.println("Oops: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.err.println("Error in input: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Unexpected error:" + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter current event index to delete: ");
                    int indexToRemove = sc.nextInt();
                    sc.nextLine();
                    try {
                        eventLog.removeEvent(indexToRemove);
                        System.out.println("Successfully deleted event.");
                    } catch (InvalidOperationException e) {
                        System.err.println("Oops: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.err.println("Error in input: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Unexpected error:" + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter current event index to edit: ");
                    int indexToEdit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new event: ");
                    String newEvent = sc.nextLine();
                    try {
                        eventLog.editEvent(indexToEdit, newEvent);
                        System.out.println("Successfully edit event.");
                    } catch (InvalidOperationException e) {
                        System.out.println("Oops: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.err.println("Error in input: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Unexpected error:" + e.getMessage());
                    }
                    break;

                case 4:
                    eventLog.printEvents();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again: ");
                    break;
            }
        }
    }
}
