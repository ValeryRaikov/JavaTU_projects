public class BrokenDevice extends Device {
    private String issues;
    private int repairDays;

    public BrokenDevice(String brand, String model, double price, String issues, int repairDays) {
        super(brand, model, price);
        this.issues = issues;
        this.repairDays = repairDays;
    }

    public String getIssues() {
        return this.issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    public int getRepairDays() {
        return this.repairDays;
    }

    public void setRepairDays(int repairDays) {
        this.repairDays = repairDays;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Issues: " + issues);
        System.out.println("Repair Days: " + repairDays);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Issues: %s, Repair Days: %d days", this.issues, this.repairDays);
    }

    public static BrokenDevice fromString(String input) {
        String[] parts = input.split(",");
        String brand = parts[0].split(":")[1].trim();
        String model = parts[1].split(":")[1].trim();
        double price = Double.parseDouble(parts[2].split(":")[1].trim());
        String issues = parts[3].split(":")[1].trim();
        int repairDays = Integer.parseInt(parts[4].split(":")[1].trim());
        return new BrokenDevice(brand, model, price, issues, repairDays);
    }
}