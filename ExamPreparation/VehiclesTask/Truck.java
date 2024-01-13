package VehiclesTask;

public class Truck extends Vehicle {
    public Truck(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TRUCK;
    }

    @Override
    public String toString() {
        return "Truck{}" + super.toString();
    }
}
