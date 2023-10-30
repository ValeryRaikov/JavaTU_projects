import java.util.Dictionary;

public abstract class AbstractVehicle {
    private String brand;
    private String model;
    private int year;
    private String engine;
    private int mileage;
    private float price;
    private float rating;

    public AbstractVehicle() {
        this.brand = "";
        this.model = "";
        this.year = 0;
        this.engine = "";
        this.mileage = 0;
        this.price = 0;
        this.rating = 0;
    }

    public AbstractVehicle(String brand, String model, int year, String engine, int mileage, float price, float rating) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.mileage = mileage;
        this.price = price;
        this.rating = rating;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        if (this.brand.isEmpty()) {
            System.out.println("Please enter a valid car brand!");
            System.exit(1);
        }
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        if (this.model.isEmpty()) {
            System.out.println("Please enter a valid car model!");
            System.exit(1);
        }
        this.model = model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        final int minYear = 1965;
        if (this.year <= minYear) {
            System.out.println("No cars before " + minYear + " year!");
            System.exit(1);
        }
        this.year = year;
    }

    public String getEngine() {
        return this.engine;
    }

    public void setEngine(String engine) {
        if (this.engine.isEmpty()) {
            System.out.println("Please enter a valid car engine type!");
            System.exit(1);
        }
        this.engine = engine;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int mileage) {
        if (this.mileage < 0) {
            System.out.println("Car mileage cannot be negative!");
            System.exit(1);
        }
        this.mileage = mileage;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        final float minPrice = 3999.99f;
        if (this.price < minPrice) {
            System.out.println("Car price cannot be less than " + minPrice + "lv!");
            System.exit(1);
        }
        this.price = price;
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
        if (this.rating < 0) {
            System.out.println("Car rating cannot be less than 0!");
            System.exit(1);
        }
        this.rating = rating;
    }

    @Override
    public abstract String toString();

    public abstract int getEngineHp(Dictionary<String, Integer> engineHp, String engine);

    public abstract int getMaxSpeed(int hp);

    public abstract void getEngineSpecs(String engine);

    public abstract String Conclusion(float rating);
}