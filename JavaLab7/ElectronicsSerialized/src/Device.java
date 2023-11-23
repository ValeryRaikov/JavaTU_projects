import java.io.Serializable;
import java.util.Scanner;

public class Device implements Serializable {
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

    public static Device createDevice(Scanner sc) {
        System.out.println("Input data for working device...");

        System.out.print("Enter device brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter device model: ");
        String model = sc.nextLine();
        System.out.print("Enter device price: ");
        double price = sc.nextDouble();

        sc.nextLine();

        return new Device(brand, model, price);
    }

    @Override
    public String toString() {
        return String.format("Brand: %s, Model: %s, Price: %.2f", this.brand, this.model, this.price);
    }

}