import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public abstract class BaseEquipment implements Serializable {
    private String brand;
    private String model;
    private int length;
    double price;

    public BaseEquipment(String brand, String model, int length, double price) throws InvalidOperation {
        setBrand(brand);
        setModel(model);
        setLength(length);
        setPrice(price);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws InvalidOperation {
        if (brand.isEmpty())
            throw new InvalidOperation();

        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws InvalidOperation {
        if (model.isEmpty())
            throw new InvalidOperation();

        this.model = model;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) throws InvalidOperation {
        if (length <= 50)
            throw new InvalidOperation();

        this.length = length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidOperation {
        if (price <= 39.99)
            throw new InvalidOperation();

        this.price = price;
    }

    @Override
    public String toString() {
        return "BaseEquipment{" +
                "brand=" + getBrand() +
                ", model=" + getModel() +
                ", length=" + getLength() +
                ", price=" + getPrice() +
                '}';
    }
}
