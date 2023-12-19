public class SwimmingPool {
    private static final int length = 50;
    private static final int width = 20;
    private static final double depth = 2.20;
    private static final int totalCorridors = 8;
    private String name;
    private String address;
    private double price;
    private String openHours;

    public SwimmingPool(String name, String address, double price, String openHours) {
        setName(name);
        setAddress(address);
        setPrice(price);
        setOpenHours(openHours);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public static void printOlympicPool() {
        System.out.println("Olympic swimming pool is with characteristics:");
        System.out.println(
            "Length: " + SwimmingPool.length + "\nWidth: " + SwimmingPool.width +
            "\nDepth: " + SwimmingPool.depth + "\nTotal corridors: " + SwimmingPool.totalCorridors
        );
    }

    @Override
    public String toString() {
        return "Olympic swimming pool " + this.getName() + " at " + this.getAddress() + " offers a monthly payment of " +
                this.getPrice() + " with working hours: " + this.getOpenHours();
    }
}
