package ObjectFileOperations;

import java.io.*;

public class Student implements Serializable {
    private String fName;
    private String lName;
    private String fNumber;

    public Student(String fName, String lName, String fNumber) {
        setfName(fName);
        setlName(lName);
        setfNumber(fNumber);
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    @Override
    public String toString() {
        return String.format("Student -> %s %s with faculty number: %s", getfName(), getlName(), getfNumber());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void writeStudent(File file, Student student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(student);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Student readStudent(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Student)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
