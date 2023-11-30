import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PresentStore store = new PresentStore();
        Scanner sc = new Scanner(System.in);

        try {
            Product1 product1 = new Product1("Product 1", 25.0, 1, 10);
            Product1 product1_1 = new Product1("Product 1_1", 30.0, 3, 5);
            Product2 product2 = new Product2("Product 2", 35.0, 2, 15);
            Product3 product3 = new Product3("Product 3", 45.0, 1, 20);

            store.addProduct(product1);
            store.addProduct(product1_1);
            store.addProduct(product2);
            store.addProduct(product3);

            System.out.print("Enter max price to filter products: ");
            double price = sc.nextDouble();

            System.out.println("Products under maximum price of " + price + ": ");
            ArrayList<GetProductsTo> productsUnderMaxPrice = store.getProductsByMaxPrice(price);
            for (GetProductsTo product : productsUnderMaxPrice) {
                System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice());
            }

            System.out.print("Enter provider id to search for products: ");
            int idOfProvider = sc.nextInt();

            System.out.println("\nProducts by provider ID " + idOfProvider + ": ");
            ArrayList<GetProductsTo> productsByProviderId = store.getProductsByProviderId(idOfProvider);
            for (GetProductsTo product : productsByProviderId) {
                if (product instanceof DeliveryAPI deliveryAPIProduct) {
                    System.out.println("Type: " + product.getType() + ", Number: " + deliveryAPIProduct.getNumber(1));
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}