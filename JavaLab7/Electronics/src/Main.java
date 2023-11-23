public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        Device device1 = new Device("Samsung", "Galaxy S22", 1700.0);
        Device device2 = new Device("LG", "O-LED TV", 999.0);

        BrokenDevice brokenDevice1 = new BrokenDevice("Apple", "Iphone 11 Max Pro", 1900.0, "Screen issue", 5);
        BrokenDevice brokenDevice2 = new BrokenDevice("HP", "Pavillion I5", 2000.0, "Battery issue", 3);

        service.addDevice(device1);
        service.addDevice(device2);
        service.receiveBrokenDevice(brokenDevice1);
        service.receiveBrokenDevice(brokenDevice2);

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

        service.writeToFile("service_data.txt");

        service.readFromFile("service_data.txt");

        System.out.println("Working Devices:");
        for (Device device : service.getWorkingDevices()) {
            System.out.println(device);
        }

        System.out.println("\nBroken Devices:");
        for (BrokenDevice brokenDevice : service.getBrokenDevices()) {
            System.out.println(brokenDevice);
        }
    }
}