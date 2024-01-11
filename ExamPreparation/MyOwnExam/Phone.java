package MyOwnExam;

public class Phone extends ElectronicDevice {
    protected static final String type = "Smartphone";
    private int size;
    private int memory;

    public Phone(String brand, int year, double price, String description, int size, int memory) {
        super(brand, year, price, description);
        setSize(size);
        setMemory(memory);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String getDeviceType() {
        return Phone.type;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("size: %d, memory: %d", getSize(), getMemory());
    }
}
