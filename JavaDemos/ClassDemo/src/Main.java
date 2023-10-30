import java.util.Dictionary;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {

        Dictionary<String, Integer> engineHp = new Hashtable<>();
        engineHp.put("1.9 TDI", 116);
        engineHp.put("2.0 TDI i1", 150);
        engineHp.put("2.0 TDI i2", 184);
        engineHp.put("3.0 TDI", 240);
        engineHp.put("4.2 TDI", 324);
        engineHp.put("5.0 TDI", 360);
        engineHp.put("1.8 T", 140);
        engineHp.put("1.8 TSI", 170);
        engineHp.put("2.0 TSI", 220);
        engineHp.put("2.0 TFSI", 280);
        engineHp.put("3.0 TFSI", 350);
        engineHp.put("4.2 TFSI", 480);
        engineHp.put("5.0 TFSI", 540);

        //Create vehicles
        Vehicle c1 = Vehicle.createVehicle();
        Vehicle c2 = Vehicle.createVehicle();
        Vehicle c3 = Vehicle.createVehicle();

        //Create an array of vehicles
        Vehicle[] carDealer = new Vehicle[3];
        carDealer[0] = c1;
        carDealer[1] = c2;
        carDealer[2] = c3;

        //Print vehicle information
        for (Vehicle car: carDealer) {
            System.out.println(car);
            System.out.println("Horse power of " + car.getBrand() + " " + car.getModel() + " with engine " + car.getEngine() + " is " + car.getEngineHp(engineHp, car.getEngine()) + "hp.");
            System.out.println("Max speed of " + car.getBrand() + " " + car.getModel() + " with engine " + car.getEngine() + " is " + car.getMaxSpeed(car.getEngineHp(engineHp, car.getEngine())) + "km/h.");
            System.out.println(car.Conclusion(car.getRating()));
            System.out.println();
        }
    }
}
