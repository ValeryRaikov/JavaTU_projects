public abstract class Stocks {
    private float price;
    private int stockNumber;

    public Stocks(float price, int stockNumber) throws PriceException {
        if (price <= 0) {
            throw new PriceException("Invalid price: " + price);
        }

        this.price = price;
        this.stockNumber = stockNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) throws PriceException {
        if (price < 0) {
            throw new PriceException("Invalid price: " + price);
        }

        this.price = price;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stocksNumber) {
        this.stockNumber = stocksNumber;
    }

    public abstract double checkPromo();
}
