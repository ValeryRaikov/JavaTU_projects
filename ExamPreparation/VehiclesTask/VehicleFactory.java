package VehiclesTask;

import java.io.PrintStream;
import java.util.Scanner;

public class VehicleFactory {
    public static Vehicle createVehicle(Scanner in, PrintStream out, VehicleType vehicleType) {
        out.println("Enter brand:");
        String brand = in.nextLine();

        out.println("Enter model:");
        String model = in.nextLine();

        out.println("Enter year:");
        int year = Integer.parseInt(in.nextLine());

        switch (vehicleType) {
            case MOTORCYCLE:
                return new Motorcycle(brand, model, year);
            case CAR:
                out.println("Enter engine type:");
                EngineType engineType = EngineType.valueOf(in.nextLine().toUpperCase());

                out.println("Enter horse power:");
                int horsePower = Integer.parseInt(in.nextLine());

                out.println("Enter fuel consumption:");
                double fuelConsumption = Double.parseDouble(in.nextLine());

                Engine engine = new Engine(engineType, horsePower, fuelConsumption);

                return new Car(brand, model, year, engine);
            case TRUCK:
                return new Truck(brand, model, year);
            case BUS:
                out.println("Enter capacity:");
                int capacity = Integer.parseInt(in.nextLine());

                return new Bus(brand, model, year, capacity);
            default:
                out.println("Invalid vehicle type!");
                return null;
        }
    }
}
