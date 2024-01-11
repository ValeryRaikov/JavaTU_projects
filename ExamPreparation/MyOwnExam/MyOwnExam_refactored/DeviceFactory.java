package MyOwnExam;

import java.util.Scanner;

public class DeviceFactory {
    public static ElectronicDevice createDevice(String deviceType) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter device brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter device year: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("Enter device price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter device description: ");
        String description = sc.nextLine();

        if (deviceType.equalsIgnoreCase(Phone.type)) {
            System.out.print("Enter device size: ");
            int size = Integer.parseInt(sc.nextLine());
            System.out.print("Enter device memory: ");
            int memory = Integer.parseInt(sc.nextLine());

            return new Phone(brand, year, price, description, size, memory);

        } else if (deviceType.equalsIgnoreCase(Computer.type)) {
            System.out.print("Enter device processor: ");
            String processor = sc.nextLine();

            return new Computer(brand, year, price, description, processor);

        } else if (deviceType.equalsIgnoreCase(Television.type)) {
            System.out.print("Enter device aspect: ");
            String aspect = sc.nextLine();
            System.out.print("Enter device resolution: ");
            String resolution = sc.nextLine();

            return new Television(brand, year, price, description, aspect, resolution);

        } else {
            System.out.println("Invalid device type!");
            return null;
        }
    }
}
