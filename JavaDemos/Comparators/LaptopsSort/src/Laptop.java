public class Laptop implements Comparable<Laptop>{
    private String brand;
    private String processor;
    private int ram;
    private double price;

    public Laptop(String brand, String processor, int ram, double price) {
        setBrand(brand);
        setProcessor(processor);
        setRam(ram);
        setPrice(price);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Laptop other) {
        int ramComparison = Integer.compare(this.ram, other.ram);

        if (ramComparison == 0) {
            return Double.compare(this.price, other.price);
        }

        return ramComparison;
    }

    @Override
    public String toString() {
        return "Laptop: {" + this.getBrand() + ", " + this.getProcessor() + ", " +
                this.getRam() + "GB, " + this.getPrice() + "$}.";
    }

}
