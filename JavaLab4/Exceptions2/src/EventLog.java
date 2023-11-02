import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class EventLog {
    private List<String> events;
    private static final int MAX_EVENTS = 100;

    public EventLog() {
        events = new ArrayList<>();
    }

    public void addEvent(String event) throws EventLimitExceededException {
        if (events.size() < MAX_EVENTS) {
            events.add(event);
        }
        throw new EventLimitExceededException("Array limit reached!");
    }

    public void removeEvent(int index) throws InvalidOperationException {
        if (index >= 0 && index < events.size()) {
            events.remove(index);
        } else {
            throw new InvalidOperationException("Invalid index for array removal!");
        }
    }

    public void editEvent(int index, String newEvent) throws InvalidOperationException {
        if (index >= 0 && index < events.size()) {
            events.set(index, newEvent);
        } else {
            throw new InvalidOperationException("Invalid index for event edit.");
        }
    }

    public void printEvents() {
        for (int i = 0; i < events.size(); i++) {
            System.out.println("Event " + i + ": " + events.get(i));
        }
    }

    public int getEventCount() {
        return events.size();
    }
}