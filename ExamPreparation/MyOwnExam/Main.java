package MyOwnExam;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String DEVICE_FILENAME = "device.bin";

    public static void main(String[] args) {
        userMenu();
    }

    public static void userMenu() {
        Scanner sc = new Scanner(System.in);
        List<ElectronicDevice> devices = new ArrayList<>();

        while (true) {
            System.out.println("""
                    User menu:
                    1 -> Create new device
                    2 -> Save created devices
                    3 -> Add device to file
                    4 -> Buy device from file
                    5 -> Sort devices list
                    (Other) -> End program!
                    """);

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Device type: ");
                    devices.add(DeviceFactory.createDevice(sc.nextLine()));
                    break;
                case 2:
                    saveDevicesToFile(devices);
                    break;
                case 3:
                    System.out.print("Device type: ");
                    addDevice(DeviceFactory.createDevice(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Device type: ");
                    System.out.println(buyDevice(DeviceFactory.createDevice(sc.nextLine())));
                    break;
                case 5:
                    printSortedDevices(devices);
                    break;
                default:
                    System.out.println("Goodbye!");
                    System.exit(1);
            }
        }
    }

    public static File createFile() throws IOException {
        File file = new File(DEVICE_FILENAME);

        if (!file.exists()) {
            boolean isCreated = file.createNewFile();

            if (!isCreated)
                throw new IOException("Error creating file!");
        }

        return file;
    }

    public static void saveDevicesToFile(List<ElectronicDevice> devices) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(createFile()))) {
            oos.writeObject(devices);
            System.out.println("Success!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<ElectronicDevice> loadDevicesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(createFile()))) {
            return (List<ElectronicDevice>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void addDevice(ElectronicDevice device) {
        List<ElectronicDevice> devices = loadDevicesFromFile();

        assert devices != null;
        for (ElectronicDevice currDevice: devices) {
            if (currDevice.getDeviceType().equals(device.getDeviceType()) &&
                currDevice.getBrand().equals(device.getBrand()) &&
                currDevice.getYear() == device.getYear() &&
                currDevice.getPrice() == device.getPrice() &&
                currDevice.getDescription().equals(device.getDescription()))
            {
                System.out.format("This %s is already in the file!", device.getDeviceType());
                return;
            }
        }

        devices.add(device);
        saveDevicesToFile(devices);
        System.out.format("Successfully added %s to file.", device.getDeviceType());
    }

    public static ElectronicDevice buyDevice(ElectronicDevice device) {
        List<ElectronicDevice> devices = loadDevicesFromFile();

        assert devices != null;
        for (ElectronicDevice currDevice: devices) {
            if (currDevice.getDeviceType().equals(device.getDeviceType()) &&
                    currDevice.getBrand().equals(device.getBrand()) &&
                    currDevice.getYear() == device.getYear() &&
                    currDevice.getPrice() == device.getPrice() &&
                    currDevice.getDescription().equals(device.getDescription()))
            {
                System.out.format("Found such %s!", device.getDeviceType());
                devices.remove(currDevice);
                saveDevicesToFile(devices);

                return currDevice;
            }
        }

        System.out.format("No such %s found!", device.getDeviceType());
        return null;
    }

    public static void printSortedDevices(List<ElectronicDevice> devices) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Select filter to sort devices:
                1 -> by device type and name alphabetically
                2 -> by device type and price
                3 -> by device type and year
                4 -> by device type and description
                (Other) -> default sorting""");

        int choice = Integer.parseInt(sc.nextLine());

        List<ElectronicDevice> sortedDevices = devices;

        if (devices.isEmpty())
            return;

        switch (choice) {
            case 1:
                sortedDevices = devices.stream().sorted(
                        Comparator.comparing(ElectronicDevice::getDeviceType)
                        .thenComparing(ElectronicDevice::getBrand))
                        .toList();
                break;
            case 2:
                sortedDevices = devices.stream().sorted(
                        Comparator.comparing(ElectronicDevice::getDeviceType)
                        .thenComparingDouble(ElectronicDevice::getPrice))
                        .toList();
                break;
            case 3:
                sortedDevices = devices.stream().sorted(
                        Comparator.comparing(ElectronicDevice::getDeviceType)
                        .thenComparingInt(ElectronicDevice::getId))
                        .toList();
                break;
            case 4:
                sortedDevices = devices.stream().sorted(
                        Comparator.comparing(ElectronicDevice::getDeviceType)
                        .thenComparing(ElectronicDevice::getDescription))
                        .toList();
                break;
            default:
                System.out.println("No sorting selected!");
                break;
        }

        sortedDevices.forEach(System.out::println);
    }
}
