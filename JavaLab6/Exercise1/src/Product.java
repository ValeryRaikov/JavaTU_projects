import java.io.Serializable;

public abstract class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int inventoryNumber;
    double price;
    int quantity;
    private Provider provider;

    public Product(int inventoryNumber, double price, int quantity, Provider provider) {
        this.inventoryNumber = inventoryNumber;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be negative number!");
        }

        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be negative number!");
        }

        this.quantity = quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        if (provider == null) {
            throw new IllegalArgumentException("Provider cannot be null value!");
        }

        this.provider = provider;
    }

    abstract double getPromotionalPrice();

    abstract boolean sellProduct(int piece) throws NoMoreProductsException;
}
