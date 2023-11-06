import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Person implements Externalizable {
    private String name;
    private LocalDate birth;
    private transient int age;

    public Person() throws IllegalArgumentException {
        throw new IllegalArgumentException("Person object cannot be empty!");
    }

    public Person(String name, LocalDate birth) throws IllegalArgumentException {
        if (this.name.isEmpty() || this.birth.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Exception during instantiation of person!");

        this.name = name;
        this.birth = birth;
        recalculateAge();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) throws IllegalArgumentException{
        if (newName.isEmpty())
            throw new IllegalArgumentException("Blank field for name is impossible!");

        this.name = newName;
    }

    public LocalDate getBirth() {
        return this.birth;
    }

    public void setBirth(LocalDate newBirth) throws IllegalArgumentException {
        if (newBirth.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Birth date cannot be in the future!");

        this.birth = newBirth;
        recalculateAge();
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) throws IllegalArgumentException {
        if (this.age <= 0 || this.age >= 100)
            throw new IllegalArgumentException("Age must be a positive number!");

        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(birth);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        birth = (LocalDate) in.readObject();
        recalculateAge();
    }

    @Override
    public String toString() {
        return "Person -> [name='" + name + "', birth=" + birth + ", age=" + age + ']';
    }

    public void recalculateAge() {
        LocalDate currentDate = LocalDate.now();
        Period agePeriod = Period.between(birth, currentDate);
        age = agePeriod.getYears();
    }
}
