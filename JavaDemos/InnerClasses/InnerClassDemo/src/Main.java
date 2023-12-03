import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Skoda", "Octavia", 20000, "diesel", 150, 155000);
        Car car2 = new Car("Mercedes", "CLS 63", 33000, "gasoline", 366, 235000);
        Car car3 = new Car("BMW", "F32", 40000, "diesel", 240, 190000);

        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));

        for (Car car: cars) {
            car.honk();
        }

        System.out.println("Cars:");
        for (Car car: cars) {
            car.printCar();
        }

        for (Car car: cars) {
            car.getEngine().startEngine();
        }

        System.out.println("Engines:");
        for (Car car: cars) {
            car.getEngine().printEngine();
        }

        // Anonymous car
        Car testCar = new Car("Opel", "Corsa", 35000, "gasoline", 120, 15000) {
            @Override
            public void printCar() {
                System.out.printf("This is another car -> %s %s and its price is -> %.2f leva.%n",
                        this.getBrand(), this.getModel(), this.getPrice());
            }
        };

        System.out.println("Test Car:");
        testCar.honk();
        testCar.printCar();
        testCar.getEngine().startEngine();
        testCar.getEngine().printEngine();
    }
}
