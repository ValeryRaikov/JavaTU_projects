import java.io.Serializable;
import java.util.Scanner;

public class BrokenDevice extends Device implements Serializable {
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

    public static BrokenDevice createBrokenDevice(Scanner sc) {
        System.out.println("Input data for broken device...");

        System.out.print("Enter broken device brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter broken device model: ");
        String model = sc.nextLine();
        System.out.print("Enter broken device price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter broken device issues: ");
        String issues = sc.nextLine();
        System.out.print("Enter broken device repair days: ");
        int repairDays = sc.nextInt();

        sc.nextLine();

        return new BrokenDevice(brand, model, price, issues, repairDays);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Issues: %s, Repair Days: %d days", this.issues, this.repairDays);
    }

}