public class Bus extends Vehicle {
    private int capacity;
    public Bus(String brand, String model, double weight, int mileage, FuelsTypes fuelType, int capacity) {
        super(brand, model, weight, mileage, fuelType);
        setCapacity(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static Bus createBus(String brand, String model, double weight, int mileage, FuelsTypes fuelType, int capacity) {
        return new Bus(brand, model, weight, mileage, fuelType, capacity);
    }

    @Override
    public String toString() {
        return "Bus{} " + super.toString() + "capacity: " + getCapacity() + "passenger seats";
    }
}