import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            House[] houses = new House[3];
            for (int i = 0; i < houses.length; i++) {
                System.out.println("Enter information for house #" + i);
                houses[i] = House.inputHouseFromConsole();
            }
            House mostSpaciousHouse = findMostSpaciousHouse(houses);
            System.out.println("\nHouse with biggest area is: ");
            mostSpaciousHouse.display();
        } catch (InvalidDataException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Invalid user input:" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error:" + e.getMessage());
        }
    }

    public static House findMostSpaciousHouse(House[] houses) {
        House mostSpacious = houses[0];
        double maxAverageHeight = mostSpacious.getHeight() / mostSpacious.getFloors();

        for (int i = 1; i < houses.length; i++) {
            double currentAverageHeight = houses[i].getHeight() / houses[i].getFloors();
            if (currentAverageHeight > maxAverageHeight) {
                mostSpacious = houses[i];
                maxAverageHeight = currentAverageHeight;
            }
        }

        return mostSpacious;
    }
}