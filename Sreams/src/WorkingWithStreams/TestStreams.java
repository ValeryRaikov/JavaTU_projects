package WorkingWithStreams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreams {
    public static void main(String[] args) {
        List<Person> people = Person.getPeople();

//        System.out.println("People:");
//        people.forEach(System.out::println);

        System.out.println("Testing stream methods:");

        System.out.println();
//        peopleOverAge30(people).forEach(System.out::println);
//        malePeople(people).forEach(System.out::println);
//        femaleUnknownPeople(people).forEach(System.out::println);

//        sortBytNameAlpha(people).forEach(System.out::println);
//        sortBytAgeDesc(people).forEach(System.out::println);

//        System.out.println(matchAnyUnknown(people));
//        System.out.println(matchAllNamesLength(people));

//        System.out.println(findMinAge(people));
//        System.out.println(findMaxAge(people));

//        groupByGender(people).forEach(((gender, people1) -> {
//            System.out.println(gender);
//            people1.forEach(System.out::println);
//        }));

//        malePeopleOver25Sorted(people).forEach(System.out::println);
//        System.out.println(femalePeopleUnder40Count(people));
    }

//    Filter methods
    public static List<Person> peopleOverAge30(List<Person> people) {
        return people.stream().filter(p -> p.getAge() > 30).limit(10).toList();
    }

    public static List<Person> malePeople(List<Person> people) {
        return people.stream().filter(p -> p.getGender().equals(Gender.MALE)).toList();
    }

    public static List<Person> femaleUnknownPeople(List<Person> people) {
        return people.stream().filter(p -> !p.getGender().equals(Gender.MALE)).toList();
    }

//    Sort methods
    public static List<Person> sortBytNameAlpha(List<Person> people) {
        return people.stream().sorted(
                Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName)
        ).toList();
    }

    public static List<Person> sortBytAgeDesc(List<Person> people) {
        return people.stream().sorted(
                Comparator.comparingInt(Person::getAge).thenComparing(Person::getFirstName).reversed()
        ).toList();
    }

//    Match methods
    public static boolean matchAnyUnknown(List<Person> people) {
        return people.stream().anyMatch(p -> p.getGender().equals(Gender.UNKNOWN));
    }

    public static boolean matchAllNamesLength(List<Person> people) {
        return people.stream().allMatch(p -> p.getFirstName().length() >= 6);
    }

//    Min/Max methods
    public static Optional<Person> findMinAge(List<Person> people) {
        return people.stream().min(Comparator.comparingInt(Person::getAge));
    }

    public static Optional<Person> findMaxAge(List<Person> people) {
        return people.stream().max(Comparator.comparingInt(Person::getAge));
    }

//    Group methods
    public static Map<Gender, List<Person>> groupByGender(List<Person> people) {
        return people.stream().collect(
                Collectors.groupingBy(Person::getGender)
        );
    }

//    Chained methods
    public static List<Person> malePeopleOver25Sorted(List<Person> people) {
        return people.stream()
                .filter(p -> p.getGender().equals(Gender.MALE) && p.getAge() > 25)
                .sorted(Comparator.comparingInt(Person::getAge).thenComparing(Person::getFirstName))
                .limit(5)
                .toList();
    }

    public static long femalePeopleUnder40Count(List<Person> people) {
        return people.stream().filter(
                p -> p.getGender().equals(Gender.FEMALE) && p.getAge() < 40
        ).count();
    }
}
