public class Device{
    private String brand;
    private String model;
    private double price;

    public Device(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Price: " + this.price);
    }

    @Override
    public String toString() {
        return String.format("Brand: %s, Model: %s, Price: %.2f", this.brand, this.model, this.price);
    }

    public static Device fromString(String input) {
        String[] parts = input.split(",");
        String brand = parts[0].split(":")[1].trim();
        String model = parts[1].split(":")[1].trim();
        double price = Double.parseDouble(parts[2].split(":")[1].trim());
        return new Device(brand, model, price);
    }
}