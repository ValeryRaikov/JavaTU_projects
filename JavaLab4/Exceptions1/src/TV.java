public class TV extends Stocks implements ElectricalAppliance {
    private String manufacturer;
    private String model;
    private int power;

    public TV(float price, int stockNumber, String manufacturer, String model, int power) throws PriceException, PowerException {
        super(price, stockNumber);

        if (power <= 0) {
            throw new PowerException("Invalid power: " + power);
        }

        this.manufacturer = manufacturer;
        this.model = model;
        this.power = power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) throws PowerException {
        if (power < 0) {
            throw new PowerException("Invalid power: " + power);
        }

        this.power = power;
    }

    @Override
    public double checkPromo() {
        return getPrice() * 0.91;
    }

    @Override
    public double calculateElectricityCost() {
        return power * 0.2;
    }
}