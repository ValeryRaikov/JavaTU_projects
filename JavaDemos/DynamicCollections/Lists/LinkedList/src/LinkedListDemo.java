import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> subjects1 = new LinkedList<>();
        List<String> subjects2 = new ArrayList<>();

        subjects1.add("Maths");
        subjects1.add("IT");
        subjects1.add("History");
        subjects1.add("Biology");
        subjects1.add("Chemistry");
        subjects1.add("French");
        subjects1.add("PE");

        subjects2.add("Maths");
        subjects2.add("IT");
        subjects2.add("History");
        subjects2.add("Biology");
        subjects2.add("Chemistry");
        subjects2.add("French");
        subjects2.add("PE");

        System.out.println("Subjects in LinkedList:");
        long start1 = System.nanoTime();
        subjects1.forEach(System.out::println);
        long finish1 = System.nanoTime();

        long timeElapsed1 = finish1 - start1;

        System.out.println("Subjects in ArrayList:");
        long start2 = System.nanoTime();
        subjects2.forEach(System.out::println);
        long finish2 = System.nanoTime();

        long timeElapsed2 = finish2 - start2;

        System.out.println("Time to loop over linked list: " + timeElapsed1 + " nsec.");
        System.out.println("Time to loop over array list: " + timeElapsed2 + " nsec.");

        long diff = Math.abs(timeElapsed1 - timeElapsed2);
        if (timeElapsed1 < timeElapsed2)
            System.out.println("Linked list is faster with difference of " + diff + "nsec.");
        else
            System.out.println("Array list is faster with difference of " + diff + " nsec.");

        long start3 = System.nanoTime();
        subjects1.remove("Biology");
        long finish3 = System.nanoTime();
        long timeElapsed3 = finish2 - start2;

        System.out.println("Remove element from linked list time: " + timeElapsed3 + " nsec.");

        long start4 = System.nanoTime();
        subjects2.remove("Biology");
        long finish4 = System.nanoTime();
        long timeElapsed4 = finish2 - start2;

        System.out.println("Remove element from array list time: " + timeElapsed4 + " nsec.");

        // as a stack
        subjects1.addFirst("English");
        subjects1.removeFirst();
        subjects1.getFirst();

        // as a queue
        subjects1.addLast("English");
        subjects1.removeLast();
        subjects1.getLast();

        long start5 = System.nanoTime();
        subjects1.indexOf("French");
        long finish5 = System.nanoTime();
        long timeElapsed5 = finish5 - start5;

        System.out.println("Get index of element in linked list time: " + timeElapsed5 + " nsec.");

        long start6 = System.nanoTime();
        subjects2.indexOf("French");
        long finish6 = System.nanoTime();
        long timeElapsed6 = finish6 - start6;

        System.out.println("Get index of element in array list time: " + timeElapsed6 + " nsec.");
    }
}
