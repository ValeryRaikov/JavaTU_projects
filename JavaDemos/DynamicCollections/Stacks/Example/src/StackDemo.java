import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> products = new Stack<>();

        // Push elements onto the stack LIFO
        products.push("apple");
        products.push("orange");
        products.push("banana");
        products.push("grapes");
        products.push("pear");

        System.out.println("Products: " + products);

        // Pop (remove) the element from the top of the products
        String poppedElement = products.pop();
        System.out.println(poppedElement);

        // Peek at the element at the top of the products without removing it
        String topElement = products.peek();
        System.out.println(topElement);

        System.out.println("Index of banana: " + products.search("banana"));

        System.out.println("Products:");
        products.forEach(System.out::println);
    }
}
