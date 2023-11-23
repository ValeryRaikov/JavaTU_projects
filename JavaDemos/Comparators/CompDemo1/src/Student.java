public class Student {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name error...");
        }

        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name error...");
        }

        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age <= 7 || age >= 18) {
            throw new IllegalArgumentException("Age error...");
        }

        this.age = age;
    }

    @Override
    public String toString() {
        return "Student (" + firstName +" "+ lastName +" "+ age + ")";
    }

}