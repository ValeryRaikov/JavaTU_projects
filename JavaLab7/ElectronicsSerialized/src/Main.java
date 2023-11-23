import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Service service = new Service();

        service.addDevice(Device.createDevice(sc));
        service.addDevice(Device.createDevice(sc));
        service.addDevice(Device.createDevice(sc));

        service.receiveBrokenDevice(BrokenDevice.createBrokenDevice(sc));
        service.receiveBrokenDevice(BrokenDevice.createBrokenDevice(sc));
        service.receiveBrokenDevice(BrokenDevice.createBrokenDevice(sc));

        System.out.println("Working Devices:");
        for (Device device : service.getWorkingDevices()) {
            device.display();
        }

        System.out.println("Broken Devices:");
        for (BrokenDevice brokenDevice : service.getBrokenDevices()) {
            brokenDevice.display();
        }

        System.out.println("Devices with Screen Issue:");
        service.printDevicesWithIssues("Screen issue");

        System.out.println("Total Price of Devices: " + service.calculateTotalPrice());

        double hourlyRate = 20.0;
        System.out.println("Potential Repair Income: " + service.calculatePotentialRepairIncome(hourlyRate));

        service.writeDevicesToFile();

        service.setWorkingDevices(service.readWorkingDevicesFromFile());
        service.setBrokenDevices(service.readBrokenDevicesFromFile());

        System.out.println("Working Devices (after reading from file):");
        for (Device device : service.getWorkingDevices()) {
            System.out.println(device);
        }

        System.out.println("\nBroken Devices (after reading from file):");
        for (BrokenDevice brokenDevice : service.getBrokenDevices()) {
            System.out.println(brokenDevice);
        }
    }
}