public class Car extends Vehicle {
    private double fuelConsumption;
    public Car(String brand, String model, double weight, int mileage, FuelsTypes fuelType, double fuelConsumption) {
        super(brand, model, weight, mileage, fuelType);
        setFuelConsumption(fuelConsumption);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public static Car createCar(String brand, String model, double weight, int mileage, FuelsTypes fuelType, double fuelConsumption) {
        return new Car(brand, model, weight, mileage, fuelType, fuelConsumption);
    }

    @Override
    public String toString() {
        return "Car{} " + super.toString() + "fuel consumption: " + getFuelConsumption() + "/100km";
    }
}