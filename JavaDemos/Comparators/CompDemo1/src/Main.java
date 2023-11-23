import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Name,Student> hashTable = new HashMap<>();

        try {
            hashTable.put(new Name("Ivan"), new Student("Ivan", "Ivanov", 20));
            hashTable.put(new Name("Peter"), new Student("Peter", "Ivanov", 22));
            hashTable.put(new Name("Ivan"), new Student("Ivan", "Petrov", 19));
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(hashTable.toString());

        TreeMap<Name, Student> sorted = new TreeMap<>(hashTable);
        System.out.println(sorted);

        try {
            sorted.put(new Name("Ivan"), new Student("Ivan","Dimitrov",23));
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(sorted);
    }

}