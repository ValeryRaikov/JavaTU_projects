package VehiclesTask;

public class Motorcycle extends Vehicle {
    public Motorcycle(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.MOTORCYCLE;
    }

    @Override
    public String toString() {
        return "Motorcycle{}" + super.toString();
    }
}
