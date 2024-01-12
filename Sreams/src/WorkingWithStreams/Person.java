package WorkingWithStreams;

import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public Person(String firstName, String lastName, int age, Gender gender) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setGender(gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static List<Person> getPeople() {
        List<Person> people = List.of(
                new Person("Ivan", "Ivanov", 20, Gender.MALE),
                new Person("Maria", "Petrova", 24, Gender.FEMALE),
                new Person("Islam", "Makhachev", 28, Gender.MALE),
                new Person("Naum", "Shopov", 25, Gender.MALE),
                new Person("Denislava", "Goteva", 41, Gender.FEMALE),
                new Person("Daniela", "Dinkova", 36, Gender.FEMALE),
                new Person("Veselin", "Plachkov", 60, Gender.UNKNOWN),
                new Person("Martin", "Marinov", 32, Gender.MALE),
                new Person("Viktoria", "Veleva", 57, Gender.FEMALE),
                new Person("Ivan", "Mitkov", 17, Gender.UNKNOWN),
                new Person("Gergana", "Mihailova", 29, Gender.FEMALE),
                new Person("Nikola", "Kolev", 43, Gender.MALE)
        );

        return people;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
