package MyOwnExam;

public class Computer extends ElectronicDevice {
    protected static final String type = "Computer";
    private String processor;
    public Computer(String brand, int year, double price, String description, String processor) {
        super(brand, year, price, description);
        setProcessor(processor);
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public String getDeviceType() {
        return Computer.type;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("processor: %s", getProcessor());
    }
}
