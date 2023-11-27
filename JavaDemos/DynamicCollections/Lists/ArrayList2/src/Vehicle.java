import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Vehicle implements Comparable<Vehicle> {
    private String brand;
    private String model;
    private int year;
    private double price;

    public Vehicle(String brand, String model, int year, double price) throws IllegalArgumentException {
        setBrand(brand);
        setModel(model);
        setYear(year);
        setPrice(price);
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String newBrand) throws IllegalArgumentException {
        if (newBrand.isEmpty()) {
            System.out.println("Brand empty error!");
            throw new IllegalArgumentException();
        }

        this.brand = newBrand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String newModel) throws IllegalArgumentException {
        if (newModel.isEmpty()) {
            System.out.println("Model empty error!");
            throw new IllegalArgumentException();
        }

        this.model = newModel;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int newYear) {
        if (newYear <= 1990 || newYear >= Year.now().getValue()) {
            System.out.println("Year error!");
            throw new IllegalArgumentException();
        }

        this.year = newYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (newPrice <= 0) {
            System.out.println("Price negative error!");
            throw new IllegalArgumentException();
        }

        this.price = newPrice;
    }

    public static Vehicle createVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vehicle creation base:");
        System.out.print("Enter brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter model: ");
        String model = sc.nextLine();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        try {
            return new Vehicle(brand, model, year, price);
        } catch (IllegalArgumentException e) {
            System.err.println("Error! " + e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "Vehicle: " + this.brand + " " + this.model + " is " + (Year.now().getValue() - this.year) + " years old.";
    }

    public Vehicle brakeVehicle(ArrayList<Vehicle> repairedVehicles) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vehicle credentials of a repaired vehicle:");
        String searchString = sc.nextLine();

        for (Vehicle vehicle: repairedVehicles) {
            if (getBrand().contains(searchString) || getModel().contains(searchString) ||
            String.valueOf(getYear()).contains(searchString) || String.valueOf(getPrice()).contains(searchString)) {
                System.out.println("Vehicle found.");
                return vehicle;
            }
        }

        System.out.println("Vehicle not found.");
        return null;
    }

    public Vehicle repairVehicle(ArrayList<Vehicle> brokenVehicles) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vehicle credentials of a broken vehicle:");
        String searchString = sc.nextLine();

        for (Vehicle vehicle: brokenVehicles) {
            if (getBrand().contains(searchString) || getModel().contains(searchString) ||
                    String.valueOf(getYear()).contains(searchString) || String.valueOf(getPrice()).contains(searchString)) {
                System.out.println("Vehicle found.");
                return vehicle;
            }
        }

        System.out.println("Vehicle not found.");
        return null;
    }

    public static void printVehicles(ArrayList<Vehicle> brokenVehicles, ArrayList<Vehicle> repairedVehicles) {
        System.out.println("Broken vehicles in the collection:");
        Collections.sort(brokenVehicles);
        for (Vehicle vehicle: brokenVehicles) {
            System.out.println(vehicle.toString());
        }

        System.out.println("Functional vehicles in the collection:");
        for (Vehicle vehicle: repairedVehicles) {
            System.out.println(vehicle.toString());
        }
    }

    @Override
    public int compareTo(Vehicle other) {
        return Integer.compare(this.year, other.year);
    }

}
