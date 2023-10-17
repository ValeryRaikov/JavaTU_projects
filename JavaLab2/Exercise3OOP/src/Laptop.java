public class Laptop extends ElectronicDevice{
    private int ramSize;
    private int hardDriveSize;

    public Laptop(double voltage, String processorModel, int ramSize, int hardDriveSize) {
        super(voltage, processorModel);
        this.ramSize = ramSize;
        this.hardDriveSize = hardDriveSize;
    }

    public boolean isBetter(Laptop otherLaptop) {
        return (this.ramSize > otherLaptop.ramSize) && (this.hardDriveSize > otherLaptop.hardDriveSize);
    }

    @Override
    public String toString() {
        return super.toString() + "\nRAM memory: " + ramSize + "GB\nSSD: " + hardDriveSize + "GB";
    }
}
