package ObjectFileOperations2;

import java.io.*;

public class Vehicle implements Serializable {
    private static final String type = "Vehicle";
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year) {
        setBrand(brand);
        setModel(model);
        setYear(year);
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
    public String toString() {
        return String.format("%s -> %s %s, %d", Vehicle.type, getBrand(), getModel(), getYear());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        Vehicle car1 = new Vehicle("Skoda", "Octavia", 2015);
        Vehicle car2 = new Vehicle("BMW", "E60", 2008);

        File file = new File("vehicles.txt");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(car1);
            oos.writeObject(car2);

            System.out.println("Successfully written vehicles to file.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println(ois.readObject());
            System.out.println(ois.readObject());
            System.out.println("Successfully read vehicles from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
