import java.io.*;

public class Motorcycle extends Vehicle {
    private int maxSpeed;
    public Motorcycle(String brand, String model, double weight, int mileage, FuelsTypes fuelType, int maxSpeed) {
        super(brand, model, weight, mileage, fuelType);
        setMaxSpeed(maxSpeed);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public static Motorcycle createMotorcycle(String brand, String model, double weight, int mileage, FuelsTypes fuelType, int maxSpeed) {
        return new Motorcycle(brand, model, weight, mileage, fuelType, maxSpeed);
    }

    public static void writeVehicleToFile(String filename, Motorcycle motorcycle) throws IOException {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(motorcycle);

            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readVehicleFromFile(String filename) throws IOException {
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream input = new ObjectInputStream(file);

            System.out.println(input.readObject());

            input.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Motorcycle{} " + super.toString() + "max speed: " + getMaxSpeed() + "km/h";
    }
}