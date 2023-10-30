import java.util.Dictionary;
import java.util.Scanner;

public class Vehicle extends AbstractVehicle{
    public Vehicle() {
        super();
    }

    public Vehicle(String brand, String model, int year, String engine, int mileage, float price, float rating) {
        super(brand, model, year, engine, mileage, price, rating);
    }

    @Override
    public String toString() {
        return "Selected vehicle:" + "\nBrand/Model: " + this.getBrand() + " " + this.getModel() + "\nYear: " + this.getYear() + "\nEngine: " + this.getEngine() + "\nMileage: " + this.getMileage() + "\nPrice: " + this.getPrice() + "\nRating: " + this.getRating();
    }

    @Override
    public int getEngineHp(Dictionary<String, Integer> engineHp, String engine) {
        Integer hp = engineHp.get(engine);

        if (hp != null) {
            return hp;
        } else {
            throw new IllegalArgumentException("Engine not found in the dictionary: " + engine);
        }
    }

    @Override
    public int getMaxSpeed(int hp) {
        switch (hp) {
            case 116:
                return 179;
            case 140:
                return 194;
            case 150:
                return 214;
            case 170:
                return 220;
            case 184:
                return 229;
            case 220:
                return 231;
            case 240:
                return 240;
            case 280:
                return 255;
            case 324:
                return 267;
            case 350:
                return 272;
            case 360:
                return 281;
            case 480:
                return 301;
            case 540:
                return 314;
            default:
                throw new IllegalArgumentException("Unknown engine horsepower: " + hp);
        }
    }

    @Override
    public void getEngineSpecs(String engine) {
        //TODO
    }

    @Override
    public String Conclusion(float rating) {
        if (rating > 9)
            return "Excellent car performance! You must definitely buy.";
        else if (rating > 6)
            return "Good car performance! You should consider buying.";
        else if (rating > 3)
            return "Poor car performance! You should buy only if needed.";
        else
            return "Awful car performance! You must avoid buying at all cost.";
    }

    public static Vehicle createVehicle() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter car brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter car model: ");
        String model = sc.nextLine();
        System.out.print("Enter car year of production: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter car engine type: ");
        String engine = sc.nextLine();
        System.out.print("Enter car mileage: ");
        int mileage = sc.nextInt();
        System.out.print("Enter car price: ");
        float price = sc.nextFloat();
        System.out.print("Enter car rating: ");
        float rating = sc.nextFloat();
        System.out.println();

        return new Vehicle(brand, model, year, engine, mileage, price, rating);
    }
}