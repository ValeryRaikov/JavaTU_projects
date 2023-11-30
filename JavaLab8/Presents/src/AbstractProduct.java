public abstract class AbstractProduct implements GetProductsTo, DeliveryAPI {
    protected String type;
    protected double price;
    protected int idOfProvider;
    protected int number;

    public AbstractProduct(String type, double price, int idOfProvider, int number) {
        this.type = type;
        this.price = price;
        this.idOfProvider = idOfProvider;
        this.number = number;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getNumber(int idOfProvider) {
        return this.idOfProvider == idOfProvider ? number : 0;
    }

    @Override
    public String getType(int idOfProvider) {
        return this.idOfProvider == idOfProvider ? type : null;
    }

    @Override
    public int getIdOfProvider() {
        return idOfProvider;
    }
}