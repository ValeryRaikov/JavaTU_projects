import java.util.Comparator;

public class Laptop {
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
    public String toString() {
        return "Laptop: {" + this.getBrand() + ", " + this.getProcessor() + ", " +
                this.getRam() + "GB, " + this.getPrice() + "$}.";
    }
}

class SortByBrand implements Comparator<Laptop> {
    @Override
    public int compare(Laptop l1, Laptop l2) {
        return l1.getBrand().compareTo(l2.getBrand());
    }
}

class SortByProcessor implements Comparator<Laptop> {
    @Override
    public int compare(Laptop l1, Laptop l2) {
        return l1.getProcessor().compareTo(l2.getProcessor());
    }
}

class SortByRam implements Comparator<Laptop> {
    @Override
    public int compare(Laptop l1, Laptop l2) {
        return Integer.compare(l1.getRam(), l2.getRam());
    }
}

class SortByPrice implements Comparator<Laptop> {
    @Override
    public int compare(Laptop l1, Laptop l2) {
        return Double.compare(l1.getPrice(), l2.getPrice());
    }
}
