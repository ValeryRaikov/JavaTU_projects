import java.io.Serializable;

public class Electronics extends Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String manufacturer;
    private String model;

    public Electronics(int inventoryNumber, double price, int quantity, Provider provider, String manufacturer, String model) {
        super(inventoryNumber, price, quantity, provider);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer.isEmpty()) {
            throw new IllegalArgumentException("Manufacturer cannot be an empty string");
        }

        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be an empty string!");
        }

        this.model = model;
    }

    @Override
    double getPromotionalPrice() {
        return price * 0.9;
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