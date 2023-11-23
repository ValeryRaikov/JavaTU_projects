import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Service {
    private List<Device> workingDevices;
    private List<BrokenDevice> brokenDevices;

    public Service() {
        this.workingDevices = new ArrayList<>();
        this.brokenDevices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        workingDevices.add(device);
    }

    public void receiveBrokenDevice(BrokenDevice brokenDevice) {
        brokenDevices.add(brokenDevice);
    }

    public void repairDevice(BrokenDevice brokenDevice) {
        brokenDevices.remove(brokenDevice);
        workingDevices.add(brokenDevice);
    }

    public List<Device> getWorkingDevices() {
        return workingDevices;
    }

    public List<BrokenDevice> getBrokenDevices() {
        return brokenDevices;
    }

    public void printDevicesWithIssues(String issue) {
        for (BrokenDevice device : brokenDevices) {
            if (device.getIssues().equalsIgnoreCase(issue)) {
                device.display();
            }
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;

        for (Device device : workingDevices) {
            totalPrice += device.getPrice();
        }
        for (BrokenDevice device : brokenDevices) {
            totalPrice += device.getPrice();
        }

        return totalPrice;
    }

    public double calculatePotentialRepairIncome(double hourlyRate) {
        double potentialIncome = 0;

        for (BrokenDevice device : brokenDevices) {
            potentialIncome += device.getRepairDays() * hourlyRate;
        }
        return potentialIncome;
    }

    public void writeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Working Devices:\n");
            for (Device device : workingDevices) {
                writer.write(device.toString() + "\n");
            }

            writer.write("\nBroken Devices:\n");
            for (BrokenDevice brokenDevice : brokenDevices) {
                writer.write(brokenDevice.toString() + "\n");
            }

            System.out.println("Service information written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void readFromFile(String filename) {
        workingDevices = new ArrayList<>();
        brokenDevices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Brand:")) {
                    workingDevices.add(Device.fromString(line));
                } else if (line.startsWith("Brand:") && line.contains("Issues:")) {
                    brokenDevices.add(BrokenDevice.fromString(line));
                }
            }

            System.out.println("Service information read from file successfully.");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

}