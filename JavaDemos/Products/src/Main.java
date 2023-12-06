import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("This is the menu of our online shop:");

        while (true) {
            System.out.println("1. Create product:");
            System.out.println("2. Delete product:");
            System.out.println("3. Apply discount:");
            System.out.println("4. Buy product:");
            System.out.println("5. Display products:");
            System.out.println("6. Filter products:");
            System.out.println("7. Write products to file:");
            System.out.println("8. Exit program:");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Product.createProduct(sc, products);
                    break;
                case 2:
                    Product.deleteProduct(sc, products);
                    break;
                case 3:
                    Product.applyDiscount(sc, products);
                    break;
                case 4:
                    Product.buyProduct(sc, products);
                    break;
                case 5:
                    Product.displayProducts(products);
                    break;
                case 6:
                    Product.filterProducts(sc, products);
                    break;
                case 7:
                    Product.writeProductsToFile(products);
                    break;
                case 8:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

    }
}
