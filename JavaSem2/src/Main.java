import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Ivan Petrov", LocalDate.of(2001, 12, 15));
        people[1] = new Person("Asen Donchev", LocalDate.of(2003, 8, 26));
        people[2] = new Person("Mihail Mitkov", LocalDate.of(2002, 6, 11));

        try {
            FileOutputStream fileOut = new FileOutputStream("person.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(people);
            out.close();
            fileOut.close();

            FileInputStream fileIn = new FileInputStream("person.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person[] deserializedPeople = (Person[]) in.readObject();
            in.close();
            fileIn.close();

            for (Person person : deserializedPeople) {
                System.out.println(person);
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Exception occurred!");
            e.printStackTrace();
        }
    }
}