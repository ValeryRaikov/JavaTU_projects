import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        Student s1 = new Student("Valery", "Raikov", new Date(), "0346120000", "FKST", "KSI");
        Student s2 = new Student("Ivan", "Mitkov", new Date(), "0448101111", "FPMI", "ISN");

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);

        File file = new File("test_file.txt");

        if (!file.exists()) {
            try {
                System.out.println("Creating file...");
                file.createNewFile();
            }
            catch (IOException e) {
                System.err.println("Error creating the file!");
                System.exit(1);
            }
        }
        else {
            System.out.println("File already exists... Overriding data.");
        }

        try (FileOutputStream writer = new FileOutputStream(file)) {
            PrintWriter pw = new PrintWriter(writer);

            pw.println("Current students:");
            for (Student s: students) {
                pw.println("First name: " + s.getFirstName());
                pw.println("Last name: " + s.getLastName());
                pw.println("Birth date: " + s.getBirthDate());
                pw.println("EGN " + s.getEGN());
                pw.println("Faculty: " + s.getFaculty());
                pw.println("Specialty: " + s.getSpecialty());
            }

            pw.close();
        }
        catch (IOException e) {
            System.err.println("Error writing to the file!");
            System.exit(1);
        }

        System.out.println("Successfully written info to " + file.getName() + " with path " + file.getAbsolutePath());

        try (FileInputStream reader = new FileInputStream(file)) {
            Scanner sc = new Scanner(reader);

            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }

            reader.close();
        }
        catch (IOException e) {
            System.err.println("Error reading from the file!");
            System.exit(1);
        }

    }
}
