import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> brokenVehicles = new ArrayList<>();
        ArrayList<Vehicle> repairedVehicles = new ArrayList<>();

        System.out.println("Initialize broken vehicles:");
        brokenVehicles.add(Vehicle.createVehicle());
//        brokenVehicles.add(Vehicle.createVehicle());
//        brokenVehicles.add(Vehicle.createVehicle());
//        brokenVehicles.add(Vehicle.createVehicle());
//        brokenVehicles.add(Vehicle.createVehicle());


        System.out.println("Initialize functional vehicles:");
        repairedVehicles.add(Vehicle.createVehicle());
//        repairedVehicles.add(Vehicle.createVehicle());
//        repairedVehicles.add(Vehicle.createVehicle());
//        repairedVehicles.add(Vehicle.createVehicle());
//        repairedVehicles.add(Vehicle.createVehicle());

        Vehicle vehicleToBreak = repairedVehicles.get(0);
        if (vehicleToBreak != null) {
            vehicleToBreak.brakeVehicle(repairedVehicles);
            brokenVehicles.add(vehicleToBreak);
            repairedVehicles.remove(vehicleToBreak);
        } else {
            System.err.println("Error! vehicleToBreak is null.");
        }

        Vehicle vehicleToRepair = brokenVehicles.get(0);
        if (vehicleToRepair != null) {
            vehicleToRepair.repairVehicle(brokenVehicles);
            repairedVehicles.add(vehicleToRepair);
            brokenVehicles.remove(vehicleToRepair);
        } else {
            System.err.println("Error! vehicleToRepair is null.");
        }

        System.out.println();
        Vehicle.printVehicles(brokenVehicles, repairedVehicles);

    }
}
