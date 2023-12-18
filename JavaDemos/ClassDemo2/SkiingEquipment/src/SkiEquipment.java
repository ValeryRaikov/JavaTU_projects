import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SkiEquipment extends BaseEquipment {
    private String type;
    private String material;
    private String skiBinding;

    public SkiEquipment(String brand, String model, int length, double price, String type, String material, String skiBinding)
            throws InvalidOperation {
        super(brand, model, length, price);
        setType(type);
        setMaterial(material);
        setSkiBinding(skiBinding);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws InvalidOperation {
        if (type.isEmpty())
            throw new InvalidOperation();

        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) throws InvalidOperation {
        if (material.isEmpty())
            throw new InvalidOperation();

        this.material = material;
    }

    public String getSkiBinding() {
        return skiBinding;
    }

    public void setSkiBinding(String skiBinding) throws InvalidOperation {
        if (skiBinding.isEmpty())
            throw new InvalidOperation();

        this.skiBinding = skiBinding;
    }

    @Override
    public String toString() {
        return "SkiEquipment{" +
                "brand=" + getBrand() +
                ", model=" + getModel() +
                ", length=" + getLength() +
                ", price=" + getPrice() +
                ", type=" + getType() +
                ", material=" + getMaterial() +
                ", skiBinding=" + getSkiBinding() +
                "} " + super.toString();
    }

    public static SkiEquipment createSkiEquipment(Scanner sc) throws InvalidOperation {
        System.out.println("Create ski equipment:");
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
        System.out.print("Enter type: ");
        String type = sc.nextLine();
        System.out.print("Enter material: ");
        String material = sc.nextLine();
        System.out.print("Enter ski binding: ");
        String skiBinding = sc.nextLine();

        try {
            return new SkiEquipment(brand, model, length, price, type, material, skiBinding);
        } catch (InvalidOperation e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void writeSkiEquipmentToFile(String filename, SkiEquipment skiEquipment) {
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
            return;
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            if (skiEquipment != null) {
                outputStream.writeObject(skiEquipment);
                System.out.println("Object written to file: " + filename);
            }
        } catch (IOException e) {
            System.err.println("Error writing object to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Comparator<SkiEquipment> compareByPrice() {
        return Comparator.comparingDouble(SkiEquipment::getPrice);
    }

    public static void sortBySkiPrice(List<SkiEquipment> skiEquipmentList) {
        skiEquipmentList.sort(compareByPrice());
    }
}
