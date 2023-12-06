import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;

public class Product {
    private String name;
    private String type;
    private String barcode;
    private double price;
    private int inStock;
    private boolean isAvailable;

    public Product(String name, String type, String barcode, double price, int inStock, boolean isAvailable) throws InvalidOperation {
        setName(name);
        setType(type);
        setBarcode(barcode);
        setPrice(price);
        setInStock(inStock);
        setAvailable();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidOperation {
        if (name.isEmpty())
            throw new InvalidOperation("Error with name! ");

        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws InvalidOperation {
        boolean isValid = false;
        for (ProductTypes productType : ProductTypes.values()) {
            if (productType.name().equals(type)) {
                isValid = true;
                break;
            }
        }
        if (isValid)
            this.type = type;
        else
            throw new InvalidOperation("Error with type! ");
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) throws InvalidOperation{
        switch (this.type){
            case "CLOTHING":
                if (!barcode.matches("^[A-Za-z]{3}\\d{4}$"))
                    throw new InvalidOperation("Error with clothing type barcode! ");
            case "SHOES":
                if (!barcode.matches("^[A-Za-z]{3}\\d{4}[A-Z]$"))
                    throw new InvalidOperation("Error with shoes type barcode! ");
                break;
            case "ACCESSORIES":
                if (!barcode.matches("^[A-Za-z]{3}\\d{4}[a-z]$"))
                    throw new InvalidOperation("Error with accessories type barcode! ");
                break;
            case "OTHER":
                if (!barcode.matches("^[A-Za-z]{3}\\d{5}$"))
                    throw new InvalidOperation("Error with other type barcode! ");
                break;
            default:
                throw new InvalidOperation("Chosen type is invalid!");
        }

        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidOperation {
        if (price <= 0 || price > 10000)
            throw new InvalidOperation("Error with price! ");

        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) throws InvalidOperation {
        if (inStock < 0 || inStock > 1000)
            throw new InvalidOperation("Error with number of products in stock!");

        this.inStock = inStock;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable() {
        this.isAvailable = this.inStock > 0;
    }

    public static void createProduct(Scanner sc, List<Product> products) {
        System.out.println("Enter data for product:");
        sc.nextLine();
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product type: ");
        String type = sc.nextLine().toUpperCase();
        System.out.print("Enter product barcode: ");
        String barcode = sc.nextLine();
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        System.out.print("Enter product quantity in stock: ");
        int inStock = sc.nextInt();
        boolean isAvailable = inStock > 0;

        try {
            Product product = new Product(name, type, barcode, price, inStock, isAvailable);
            products.add(product);
            System.out.println("Product added successfully.");
        } catch (InvalidOperation e) {
            System.err.println("At least one field mistaken by user input!");
        }
    }

    public static void deleteProduct(Scanner sc, List<Product> products) {
        System.out.print("Enter name of product to delete: ");
        String name = sc.nextLine();

        for (Product product: products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                System.out.println("Product removed successfully.");
                return;
            }
        }

        System.out.println("No product with such name found!");
    }

    public static void applyDiscount(Scanner sc, List<Product> products) {
        System.out.print("Enter discount in percentage: ");
        int discount = sc.nextInt();

        if (discount <= 0 || products.isEmpty())
            return;
        else {
            for (Product product: products) {
                product.price *= (double) (100 - discount) / 100;
            }
        }

        System.out.println("Discount applied successfully!");
    }

    public static void buyProduct(Scanner sc, List<Product> products) {
        System.out.print("Enter product name to buy: ");
        String name = sc.nextLine();
        System.out.print("Enter product quantity you want to buy: ");
        int quantity = sc.nextInt();

        for (Product product: products) {
            if (product.getName().equals(name) && product.getInStock() > quantity) {
                product.inStock -= quantity;
                double totalPrice = quantity * product.getPrice();
                System.out.println("Bought " + quantity + "X of " + product.getName() + "for the amount of " + totalPrice + "lv.");
                return;
            }
        }

        System.out.println("Purchase failed!");
    }

    public static void displayProducts(List<Product> products) {
        System.out.println("All products:");
        products.forEach(System.out::println);
    }

    public static void filterProducts(Scanner sc, List<Product> products) {
        System.out.print("Enter product type to filter products: ");
        String type = sc.nextLine().toUpperCase();

        try {
            ProductTypes.valueOf(type);

            List<Product> filteredProducts = new ArrayList<>();

            for (Product product : products) {
                if (product.getType().equals(type)) {
                    filteredProducts.add(product);
                }
            }

            if (filteredProducts.isEmpty()) {
                System.out.println("No products found with the specified type.");
                return;
            } else {
                System.out.println("Filtered products:");
                filteredProducts.forEach(System.out::println);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid product type. Please enter a valid type.");
        }
    }

    public static void writeProductsToFile(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"))) {
            File file = new File("products.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            for (Product product : products) {
                writer.write(product.toString());
                writer.newLine();
            }
            System.out.println("Products written to file successfully.");

        } catch (IOException e) {
            System.err.println("Error writing products to file: " + e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && inStock == product.inStock && isAvailable == product.isAvailable && Objects.equals(name, product.name) && Objects.equals(type, product.type) && Objects.equals(barcode, product.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, barcode, price, inStock, isAvailable);
    }

    @Override
    public String toString() {
        return "Product -> Name: " + this.getName() + ", Type: " + this.getType() + ", Barcode: " + this.getBarcode() +
            ", Price: " + this.getPrice() + ", In stock: " + this.getInStock() + ", Available: " + this.isAvailable + ".";
    }
}
