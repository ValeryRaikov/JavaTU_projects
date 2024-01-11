package MyOwnExam;

import java.io.Serializable;

public abstract class ElectronicDevice implements Serializable {
    protected static final String type = "Electronic Device";
    private static int nextId = 1;
    private int id;
    private String brand;
    private int year;
    private double price;
    private String description;

    public ElectronicDevice(String brand, int year, double price, String description) {
        setId(nextId++);
        setBrand(brand);
        setYear(year);
        setPrice(price);
        setDescription(description);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        ElectronicDevice.nextId = nextId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String getDeviceType();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("%s -> id: %d, brand: %s, year: %d, price: %f, description: %s, ",
                getDeviceType(), getId(), getBrand(), getYear(), getPrice(), getDescription());
    }
}
