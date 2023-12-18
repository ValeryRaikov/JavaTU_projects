import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SnowboardEquipment extends BaseEquipment {
    private String profile;
    private int width;
    private String variation;

    public SnowboardEquipment(String brand, String model, int length, double price, String profile, int width, String variation)
            throws InvalidOperation {
        super(brand, model, length, price);
        setProfile(profile);
        setWidth(width);
        setVariation(variation);
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) throws InvalidOperation {
        if (profile.isEmpty())
            throw new InvalidOperation();

        this.profile = profile;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws InvalidOperation {
        if (width <= 15)
            throw new InvalidOperation();

        this.width = width;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) throws InvalidOperation {
        if (variation.isEmpty())
            throw new InvalidOperation();

        this.variation = variation;
    }

    @Override
    public String toString() {
        return "SnowboardEquipment{" +
                "brand=" + getBrand() +
                ", model=" + getModel() +
                ", length=" + getLength() +
                ", price=" + getPrice() +
                ", profile=" + getProfile() +
                ", width=" + getWidth() +
                ", variation=" + getVariation() +
                "} " + super.toString();
    }

    public static SnowboardEquipment createSnowboardEquipment(Scanner sc) throws InvalidOperation {
        System.out.println("Create snowboard equipment:");
        sc.nextLine();
        System.out.print("Enter brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter model: ");
        String model = sc.nextLine();
        System.out.print("Enter length: ");
        int length = sc.nextInt();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter profile: ");
        String profile = sc.nextLine();
        System.out.print("Enter width: ");
        int width = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter variation: ");
        String variation = sc.nextLine();

        try {
            return new SnowboardEquipment(brand, model, length, price, profile, width, variation);
        } catch (InvalidOperation e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void writeSnowboardEquipmentToFile(String filename, SnowboardEquipment snowboardEquipment) {
        try {
            File file = new File(filename);

            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getAbsolutePath());
                } else {
                    System.out.println("Unable to create file");
                }
            } else {
                System.out.println("File " + filename + " already exists");
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            e.printStackTrace();
            return; // Exit method if file creation fails
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            if (snowboardEquipment != null) {
                outputStream.writeObject(snowboardEquipment);
                System.out.println("Object written to file: " + filename);
            }
        } catch (IOException e) {
            System.err.println("Error writing object to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Comparator<SnowboardEquipment> compareByPrice() {
        return Comparator.comparingDouble(SnowboardEquipment::getPrice);
    }

    public static void sortBySnowboardPrice(List<SnowboardEquipment> snowboardEquipmentList) {
        snowboardEquipmentList.sort(compareByPrice());
    }
}
