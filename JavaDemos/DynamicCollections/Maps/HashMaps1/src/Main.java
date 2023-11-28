// Basic Java program to demonstrate the main functionality of HashMaps

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> students = new HashMap<>();

        // name, fac_number
        students.put("Valery", 121222139);
        students.put("Ivan", 121222147);
        students.put("Nikolay", 121222025);
        students.put("Martin", 121222078);
        students.put("Maria", 121222101);

        System.out.println("Student's info: " + students);

        HashMap<String, Integer> copyStudents = new HashMap<>();
        copyStudents.putAll(students);
        System.out.println("Copy of student's info: " + copyStudents);

        copyStudents.remove("Nikolay");
        copyStudents.remove("Martin", 121222078);
        copyStudents.remove("");

        System.out.println("Student's info: " + copyStudents);

        System.out.println(students.get("Valery"));
        System.out.println(students.get("Ivelin"));

        System.out.println("Faculty numbers: " + students.values());

        if (students.containsKey("Stoicho")) {
            System.out.println("Stoicho is in the collection.");
            System.out.println(students.get("Stoicho"));
        } else
            System.out.println("Stoicho is not in the collection.");

        if (students.containsValue(121222139))
            System.out.println("Student with faculty number 121222139 is in the collection.");

        System.out.println(students.isEmpty());
        System.out.println("Total students: " + students.size());

        students.replace("Ivan", 121222148);

        System.out.println(students);

        copyStudents.clear();

        students.putIfAbsent("Ivan", 121222149);
        students.putIfAbsent("Gergana", 121222114);

        System.out.println(students);

        System.out.println(students.getClass());

        System.out.println("Names: " + students.keySet());
        System.out.println("Hashmap hashcode: " + students.hashCode());

        // I
        for (HashMap.Entry<String, Integer> entry : students.entrySet()) {
            String name = entry.getKey();
            int id = entry.getValue();
            System.out.println(name + ": " + id);
        }

        // II
        Iterator<HashMap.Entry<String, Integer>> iterator = students.entrySet().iterator();

        while(iterator.hasNext()) {
            HashMap.Entry<String, Integer> entry = iterator.next();
            String name = entry.getKey();
            int id = entry.getValue();
            System.out.println("Name: " + name + ", ID: " + id);
        }

        // III
        students.forEach((name, id) -> System.out.println(name + ": " + id));

    }
}
