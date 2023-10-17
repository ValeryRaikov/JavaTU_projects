public class ElectronicDevice {
    private double voltage;
    private String processorModel;
    private boolean isOn;

    public ElectronicDevice(double voltage, String processorModel) {
        this.voltage = voltage;
        this.processorModel = processorModel;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("The device in currently ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("The device is currently OFF.");
    }

    @Override
    public String toString() {
        return "Current voltage: " + voltage + "V\nProcessor: " + processorModel + "\nON: " + isOn;
    }
}
