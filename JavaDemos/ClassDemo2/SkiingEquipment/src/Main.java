import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidOperation {
        Scanner sc = new Scanner(System.in);

        List<SkiEquipment> skiEquipments = new ArrayList<>();
        List<SnowboardEquipment> snowboardEquipments = new ArrayList<>();

        try {
            skiEquipments.add(SkiEquipment.createSkiEquipment(sc));
            skiEquipments.add(SkiEquipment.createSkiEquipment(sc));
            skiEquipments.add(SkiEquipment.createSkiEquipment(sc));
        } catch (InvalidOperation e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        for (SkiEquipment skiEquipment : skiEquipments) {
            SkiEquipment.writeSkiEquipmentToFile("ski_equipment.txt", skiEquipment);
        }

        SkiEquipment skiToCompare = SkiEquipment.createSkiEquipment(sc);
        for (SkiEquipment skiEquipment : skiEquipments) {
            int result = SkiEquipment.compareByPrice().compare(skiEquipment, skiToCompare);

            if (result == 0) {
                System.out.println("The prices are equal.");
            } else if (result < 0) {
                System.out.println(skiEquipment + " has a lower price than the ski to compare.");
            } else {
                System.out.println(skiEquipment + " has a higher price than the ski to compare.");
            }
        }

        SkiEquipment.sortBySkiPrice(skiEquipments);
        skiEquipments.forEach(System.out::println);


        try {
            snowboardEquipments.add(SnowboardEquipment.createSnowboardEquipment(sc));
            snowboardEquipments.add(SnowboardEquipment.createSnowboardEquipment(sc));
            snowboardEquipments.add(SnowboardEquipment.createSnowboardEquipment(sc));
        } catch (InvalidOperation e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


        for (SnowboardEquipment snowboardEquipment : snowboardEquipments) {
            SnowboardEquipment.writeSnowboardEquipmentToFile("snowboard_equipment.txt", snowboardEquipment);
        }

        SnowboardEquipment snowboardToCompare = SnowboardEquipment.createSnowboardEquipment(sc);
        for (SnowboardEquipment snowboardEquipment : snowboardEquipments) {
            int result = SnowboardEquipment.compareByPrice().compare(snowboardEquipment, snowboardToCompare);

            if (result == 0) {
                System.out.println("The prices are equal.");
            } else if (result < 0) {
                System.out.println(snowboardEquipment + " has a lower price than the snowboard to compare.");
            } else {
                System.out.println(snowboardEquipment + " has a higher price than the snowboard to compare.");
            }
        }

        SnowboardEquipment.sortBySnowboardPrice(snowboardEquipments);
        snowboardEquipments.forEach(System.out::println);
    }
}
