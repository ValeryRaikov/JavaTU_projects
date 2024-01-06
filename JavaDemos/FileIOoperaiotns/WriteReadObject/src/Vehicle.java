import java.io.*;
import java.util.Objects;

public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    private String brand;
    private String model;
    private double weight;
    private char category;
    private int mileage;
    private FuelsTypes fuelType;

    public Vehicle(String brand, String model, double weight, int mileage, FuelsTypes fuelType) {
        setBrand(brand);
        setModel(model);
        setWeight(weight);
        setCategory();
        setMileage(mileage);
        setFuelType(fuelType);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char getCategory() {
        return category;
    }

    public void setCategory() {
        if (getWeight() < 0.2)
            this.category = 'A';
        else if (getWeight() < 3.5)
            this.category = 'B';
        else if (getWeight() < 7.5)
            this.category = 'C';
        else
            this.category = 'D';
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public FuelsTypes getFuelType() {
        return fuelType;
    }

    private void setFuelType(FuelsTypes fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle {\n" +
                "brand: " + getBrand() + "\n" +
                "model: " + getModel() + "\n" +
                "weight: " + getWeight() + "\n" +
                "category: " + getCategory() + "\n" +
                "mileage: " + getMileage() + "\n" +
                "fuel type: " + getFuelType() + "\n" +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(weight, vehicle.weight) == 0 && category == vehicle.category && mileage == vehicle.mileage && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(fuelType, vehicle.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, weight, category, mileage, fuelType);
    }
}
