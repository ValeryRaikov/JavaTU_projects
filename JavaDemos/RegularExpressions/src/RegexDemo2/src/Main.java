import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ivan", "Ivanov", 19, "student from Sofia");
        Person p2 = new Person("Boyko", "Krystev", 34, "backend developer in VW ware");
        Person p3 = new Person("Kristina", "Veleva", 25, "graduated from MU last year");
        Person p4 = new Person("Ivaylo", "Nikolov", 40, "taxi driver");
        Person p5 = new Person("Ivelina", "Todorova", 60, "happy grandmother of two");

        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        List<Person> filteredPeople = new ArrayList<>();

        System.out.println("People: " + people);

        Pattern pattern = Pattern.compile("^I");
        for (Person p: people) {
            Matcher matcher = pattern.matcher(p.getFirstName());

            if (matcher.find()) {
                filteredPeople.add(p);
            }
        }

        System.out.println("People with names starting with 'I': " + filteredPeople);
    }
}
