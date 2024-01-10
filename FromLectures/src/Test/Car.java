package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {
    private static final String category = "Vehicle";
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("Car -> %s %s, %d", getBrand(), getModel(), getYear());
    }

    public static File createFile() {
        return new File("cars.txt");
    }

    public static void saveCars(List<Car> cars) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(createFile()))) {
            oos.writeObject(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCars2(List<Car> cars) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(createFile()))) {
            for (Car car: cars) {
                oos.writeObject(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> loadCars() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(createFile()))) {
            return (List<Car>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Car> loadCars2() {
        List<Car> cars = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(createFile()))) {
            boolean endOfFile = false;

            while (!endOfFile) {
                try {
                    Car car = (Car) ois.readObject();
                    cars.add(car);
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cars;
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Skoda", "Superb", 2019));
        cars.add(new Car("Toyota", "Camry", 2017));
        cars.add(new Car("Audi", "S5", 2021));

//        First way to do it
        saveCars(cars);
        System.out.println(loadCars());

//        Second way to do it
        saveCars2(cars);
        System.out.println(loadCars2());
    }
}
