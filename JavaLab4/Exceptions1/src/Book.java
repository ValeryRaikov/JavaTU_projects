public class Book extends Stocks {
    private String author;
    private String title;

    public Book(float price, int stockNumber, String author, String title) throws PriceException {
        super(price, stockNumber);
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public double checkPromo() {
        return this.getPrice() * 0.85;
    }
}