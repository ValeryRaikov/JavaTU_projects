import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>(Arrays.asList(
                new Laptop("HP Pavilion", "Intel Core I5", 8, 1299.99),
                new Laptop("Acer Predator", "AMD Ryzen 9", 16, 2899.99),
                new Laptop("Lenovo ThinkPad", "Intel Core I7", 12, 1699.99),
                new Laptop("Apple MacBook", "Intel Core I5", 8, 1999.99),
                new Laptop("Asus Zenbook 14", "AMD Ryzen 7", 12, 2299.99)
        ));

        laptops.sort(new SortByBrand());
        System.out.println("Laptops sorted by brand:");
        laptops.forEach(System.out::println);
        System.out.println();

        laptops.sort(new SortByProcessor());
        System.out.println("Laptops sorted by processor:");
        laptops.forEach(System.out::println);
        System.out.println();

        laptops.sort(new SortByRam());
        System.out.println("Laptops sorted by RAM:");
        laptops.forEach(System.out::println);
        System.out.println();

        laptops.sort(new SortByPrice());
        System.out.println("Laptops sorted by price:");
        laptops.forEach(System.out::println);
        System.out.println();

        // Could be refactored to a separate function...
        System.out.println("Laptops with 12GB RAM:");
        List<Laptop> laptopsWith12GBRam = laptops.stream()
                .filter(laptop -> laptop.getRam() == 12)
                .sorted(new SortByPrice())
                .toList();

        laptopsWith12GBRam.forEach(System.out::println);
    }
}