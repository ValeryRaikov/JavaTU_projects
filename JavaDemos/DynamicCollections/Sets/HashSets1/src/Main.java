// Basic Java program to demonstrate the main functionality of HashSets

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Set<String> uniqueNames = new HashSet<>(Set.of("Ivan", "Peter", "Stanimir", "Anton"));
        System.out.println("Names: " + uniqueNames);

        uniqueNames.clear();
        System.out.println("Names: " + uniqueNames);

        uniqueNames.add("Mihail");
        uniqueNames.add("Blagoy");
        uniqueNames.add("Stamen");
        uniqueNames.add("Viktor");
        uniqueNames.add("Blagoy");

        System.out.println("Names: " + uniqueNames);

        uniqueNames.remove("Blagoy");
        System.out.println("Names: " + uniqueNames);

        if (uniqueNames.contains("Mihail"))
            System.out.println("Mihail is in the collection.");
        else
            System.out.println("Mihail is not in the collection.");

        Set<String> uniqueNames2 = new HashSet<>(Set.of("Peter", "Valentin", "Kristian"));
        System.out.println(uniqueNames.equals(uniqueNames2));

        System.out.println(uniqueNames.isEmpty());
        System.out.println("Names count in the collection: " + uniqueNames.size());
        System.out.println(Arrays.toString(uniqueNames.toArray()));

        System.out.println("Names:");
        Iterator<String> iterator = uniqueNames.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("Names:");
        uniqueNames2.forEach(System.out::println);

        System.out.println(uniqueNames2.getClass());

    }
}
