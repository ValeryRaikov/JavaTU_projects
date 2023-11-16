import java.util.ArrayList;
import java.io.IOException;

public class BlackFriday {
    private static Electronics[] electronics;
    private static Book[] books;

    public static void processSales() {
        try {
            ProductLoader productLoader = new ProductLoader("salesproducts.txt");
            Object[] products = productLoader.importDataFromFile();

            ArrayList<Electronics> electronicsList = new ArrayList<>();
            ArrayList<Book> booksList = new ArrayList<>();

            for (Object product : products) {
                if (product instanceof Electronics) {
                    electronicsList.add((Electronics) product);
                } else if (product instanceof Book) {
                    booksList.add((Book) product);
                }
            }

            electronics = electronicsList.toArray(new Electronics[0]);
            books = booksList.toArray(new Book[0]);

        } catch (IOException e) {
            // Log the exception or handle it more gracefully
            System.err.println("Error loading products: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        processSales();

        if (electronics != null) {
            System.out.println("Electronics:");
            for (Electronics electronic : electronics) {
                System.out.println(electronic.getManufacturer() + " " + electronic.getModel());
            }
        } else {
            System.out.println("No electronics data available.");
        }

        if (books != null) {
            System.out.println("\nBooks:");
            for (Book book : books) {
                System.out.println(book.getAuthor() + " - " + book.getTitle());
            }
        } else {
            System.out.println("No books data available.");
        }
    }
}
