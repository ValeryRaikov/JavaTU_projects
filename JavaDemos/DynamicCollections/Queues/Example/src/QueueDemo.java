import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> products = new LinkedList<>();

        //Add elements by order FIFO
        products.offer("apple");
        products.offer("orange");
        products.offer("banana");
        products.offer("grapes");
        products.offer("pear");

        System.out.println("Products: " + products);

        // Can also use add method
        products.add("peach");
        products.add("mango");

        System.out.println("Products: " + products);

        String removedElement = products.poll();
        System.out.println(removedElement);

        // Can also use remove
        System.out.println(products.remove());
        System.out.println(products.remove("pear"));

        System.out.println("Products: " + products);

        // Peek at the element at the top of the products without removing it
        String frontElement = products.peek();
        System.out.println(frontElement);

        System.out.println(products.element());

        System.out.println("Products:");
        products.forEach(System.out::println);
    }
}
