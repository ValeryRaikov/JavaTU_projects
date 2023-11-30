import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();

        laptops.add(new Laptop("HP Pavilion", "Intel Core I5", 8, 1299.99));
        laptops.add(new Laptop("Acer Predator", "AMD Ryzen 9", 16, 2899.99));
        laptops.add(new Laptop("Lenovo ThinkPad", "Intel Core I7", 12, 1699.99));
        laptops.add(new Laptop("Apple MacBook", "Intel Core I5", 8, 1999.99));

        // Ascending by ram
        Collections.sort(laptops);
        System.out.println("Laptops for sale:");
        for (Laptop laptop: laptops) {
            System.out.println(laptop);
        }

        // Descending by ram
        laptops.sort(Collections.reverseOrder());
        System.out.println("Laptops for sale:");
        laptops.forEach(System.out::println);
    }
}
