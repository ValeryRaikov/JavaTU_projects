import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            Book book = new Book(20.0f, 101, "Ivan Vazov", "Pod igoto");
            TV tv = new TV(800.0f, 201, "Samsung", "Galaxy S22", 100);

            double promoPriceBook = book.checkPromo();
            double promoPriceTV = tv.checkPromo();

            System.out.println("Book price with promotion: " + promoPriceBook);
            System.out.println("TV price with promotion: " + promoPriceTV);

            if (promoPriceBook <= 0) {
                throw new PriceException("Invalid price!");
            }
            if (tv.getPower() <= 0) {
                throw new PowerException("Invalid TV power!");
            }
        } catch (PriceException e) {
            System.err.println(e.getMessage());
        } catch (PowerException e) {
            System.err.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Error in user input: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error!" + e.getMessage());
        }
    }
}