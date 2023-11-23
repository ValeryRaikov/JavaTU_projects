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

    public List<Device> getWorkingDevices() {
        return workingDevices;
    }

    public void setWorkingDevices(List<Device> workingDevices) {
        this.workingDevices = workingDevices;
    }

    public List<BrokenDevice> getBrokenDevices() {
        return brokenDevices;
    }

    public void setBrokenDevices(List<BrokenDevice> brokenDevices) {
        this.brokenDevices = brokenDevices;
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

    public void writeDevicesToFile() {
        try (FileOutputStream fos = new FileOutputStream("service_data.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(getWorkingDevices());
            oos.writeObject(getBrokenDevices());

        } catch (IOException e) {
            System.err.println("Error writing to file! " + e.getMessage());
        }
    }

    public List<Device> readWorkingDevicesFromFile() {
        List<Device> workingDevices = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("service_data.txt"))) {
            workingDevices = (List<Device>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading working devices from file! " + e.getMessage());
        }

        return workingDevices;
    }

    public List<BrokenDevice> readBrokenDevicesFromFile() {
        List<BrokenDevice> brokenDevices = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("service_data.txt"))) {
            ois.readObject();
            brokenDevices = (List<BrokenDevice>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading broken devices from file! " + e.getMessage());
        }

        return brokenDevices;
    }

}