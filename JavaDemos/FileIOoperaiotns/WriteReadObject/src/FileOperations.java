import java.io.*;

public class FileOperations {
    public static void main(String[] args) {
        Motorcycle m1 = Motorcycle.createMotorcycle("Suzuki", "Maruti", 0.150, 25000, FuelsTypes.PETROL, 224);

        try {
            Motorcycle.writeVehicleToFile("motorcycles.txt", m1);
            Motorcycle.readVehicleFromFile("motorcycles.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
