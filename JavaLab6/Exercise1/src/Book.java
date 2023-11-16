import java.io.Serializable;

public class Book extends Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String author;
    private String title;

    public Book(int inventoryNumber, double price, int quantity, Provider provider, String author, String title) {
        super(inventoryNumber, price, quantity, provider);
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be an empty string!");
        }

        this.author = author;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be an empty string!");
        }

        this.title = title;
    }

    @Override
    double getPromotionalPrice() {
        return price * 0.5;
    }

    @Override
    boolean sellProduct(int piece) throws NoMoreProductsException {
        if (quantity >= piece) {
            quantity -= piece;
            return true;
        } else {
            throw new NoMoreProductsException("Not enough products!");
        }
    }
}