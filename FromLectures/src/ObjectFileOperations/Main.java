package ObjectFileOperations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student s1 = new Student("Valery", "Raikov", "121222139");
        Student s2 = new Student("Ivailo", "Mitov", "121222154");
        Student s3 = new Student("Viktoria", "Borisova", "121222100");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        File file = new File("students.txt");

        System.out.println("Writing students to the file...");
        for (Student student: students) {
            Student.writeStudent(file, student);
        }

        System.out.println("Reading students from the file...");
        List<Student> readStudents = new ArrayList<>();
        while (true) {
            Student student = Student.readStudent(file);

            if (student == null) {
                System.out.println("End of file reached. Exiting the loop.");
                break;
            }

            readStudents.add(student);
        }

        for (Student student : readStudents) {
            System.out.println(student);
        }
    }
}
