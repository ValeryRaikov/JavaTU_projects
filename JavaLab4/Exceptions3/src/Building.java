import java.util.Scanner;

public class Building {
    private int height;
    private double area;
    private String address;

    public Building(int height, double area, String address) throws InvalidDataException {
        if (height <= 0 || area <= 0) {
            throw new InvalidDataException("Invalid height or area!");
        }
        this.height = height;
        this.area = area;
        this.address = address;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws InvalidDataException {
        if (height <= 0) {
            throw new InvalidDataException("Invalid height! " + height);
        }
        this.height = height;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) throws InvalidDataException {
        if (area <= 0) {
            throw new InvalidDataException("Invalid area! " + area);
        }
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Building inputBuildingFromConsole() throws InvalidDataException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height in meters: ");
        int height = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter area in square meters: ");
        double area = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        if (height <= 0 || area <= 0) {
            throw new InvalidDataException("Height and area must be positive numbers!");
        }

        return new Building(height, area, address);
    }

    public void display() {
        System.out.println("Height: " + height + " m");
        System.out.println("Area: " + area + " sq/m");
        System.out.println("Address: " + address);
    }
}