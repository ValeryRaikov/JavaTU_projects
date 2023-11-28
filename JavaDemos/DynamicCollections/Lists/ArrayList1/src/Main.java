// Basic Java program to demonstrate the main functionality of ArrayList

import javax.xml.namespace.QName;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        // add
        names.add("Valery");
        names.add("Ivan");
        names.add("Peter");
        names.add("Maria");
        names.add("Lili");

        // remove
        names.remove(0);
        names.remove("Peter");

        System.out.println("Names: " + names);

        if (names.isEmpty()) {
            System.out.println("No names in the collection.");
        }
        else {
            System.out.println(names.size() + " names in the collection.");
        }

        if (names.contains("Maria")) {
            System.out.println("Maria is in the collection.");
        }

        // set
        names.set(0, "Ivaylo");

        // get
        System.out.println(names.get(0));

        names.addFirst("Dimitar");
        names.addLast("Georgi");

        System.out.println(names);

        names.removeFirst();
        names.removeLast();

        System.out.println("Reversed names: " + names.reversed());

        names.clear();
        names.addAll(Arrays.asList("Angel", "Radoslav", "Vasilena"));
        System.out.println("New names: " + names);

        ArrayList<String> newNames = new ArrayList<>();
        newNames = names;
        System.out.println("Copy of names: " + newNames);

        System.out.println(names.equals(newNames));

        System.out.println("First name in the collection: " + names.getFirst());
        System.out.println("Last name in the collection: " + names.getLast());

        String[] arrayNames = newNames.toArray(new String[0]);
        System.out.println("Array names: " + Arrays.toString(arrayNames));
        System.out.println("Array memory address: " + arrayNames);

        if (names.contains("Radoslav")) {
            System.out.println(names.indexOf("Radoslav"));
        }

        names.replaceAll(String::toUpperCase);
        System.out.println("Uppercase names: " + names);

        Collections.sort(names);
        System.out.println("Sorted names: " + names);
        Collections.sort(names, Collections.reverseOrder());
        System.out.println("Reverse sorted names: " + names);

        names.replaceAll(String::toLowerCase);

        // iterator
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String currentName = iterator.next();
            System.out.print(currentName + '\t');
        }

        // ListIterator
        ListIterator<String> listIterator = names.listIterator();

        System.out.println("Forward traversal:");
        while (listIterator.hasNext()) {
            String name = listIterator.next();
            System.out.println(name);
        }

        System.out.println("\nBackward traversal:");
        while (listIterator.hasPrevious()) {
            String name = listIterator.previous();
            System.out.println(name);
        }

        System.out.println("Sublist of names: " + names.subList(0, 2));

        System.out.println("For each printing of names:");
        // Using forEach with a lambda expression
        names.forEach(name -> System.out.println(name));

        // Using forEach with a method reference
        names.forEach(System.out::println);
    }
}
