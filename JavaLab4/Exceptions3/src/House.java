import java.util.Scanner;

public class House extends Building {
    private int floors;
    private String ownerName;

    public House(int height, double area, String address, int floors, String ownerName) {
        super(height, area, address);
        this.floors = floors;
        this.ownerName = ownerName;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public static House inputHouseFromConsole() throws InvalidDataException {
        Building building = inputBuildingFromConsole();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter property owner name: ");
        String ownerName = sc.nextLine();

        if (floors <= 0) {
            throw new InvalidDataException("Floors number must be a positive number!");
        }

        return new House(building.getHeight(), building.getArea(), building.getAddress(), floors, ownerName);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Floors: " + floors);
        System.out.println("Property owner name: " + ownerName);
    }
}