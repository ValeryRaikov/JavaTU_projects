package MyOwnExam;

public class Television extends ElectronicDevice {
    protected static final String type = "Television";
    private String aspect;
    private String resolution;

    public Television(String brand, int year, double price, String description, String aspect, String resolution) {
        super(brand, year, price, description);
        setAspect(aspect);
        setResolution(resolution);
    }

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String getDeviceType() {
        return Television.type;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("aspect: %s, resolution: %s", getAspect(), getResolution());
    }
}
