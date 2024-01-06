public class Truck extends Vehicle {
    private int length;
    public Truck(String brand, String model, double weight, int mileage, FuelsTypes fuelType, int length) {
        super(brand, model, weight, mileage, fuelType);
        setLength(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static Truck createTruck(String brand, String model, double weight, int mileage, FuelsTypes fuelType, int length) {
        return new Truck(brand, model, weight, mileage, fuelType, length);
    }

    @Override
    public String toString() {
        return "Truck{} " + super.toString() + "length: " + getLength() + "m";
    }
}