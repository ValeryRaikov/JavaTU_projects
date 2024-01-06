public class VehicleFactory {
    public static Vehicle createVehicle(String brand, String model, double weight, int mileage, FuelsTypes fuelType, int additionalField) {
        if (weight < 0.2) {
            return new Motorcycle(brand, model, weight, mileage, fuelType, additionalField);
        } else if (weight < 3.5) {
            return new Car(brand, model, weight, mileage, fuelType, additionalField);
        } else if (weight < 7.5) {
            return new Truck(brand, model, weight, mileage, fuelType, additionalField);
        } else {
            return new Bus(brand, model, weight, mileage, fuelType, additionalField);
        }
    }
}