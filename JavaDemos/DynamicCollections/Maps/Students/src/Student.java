import javax.swing.plaf.PanelUI;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Student {
    private String name;
    private String egn;
    private String facNumber;
    private String university;
    public final String[] universities = {"SU", "TU", "MU", "UNWE", "NBU", "LTU"};

    public Student(String name, String egn, String facNumber, String university) throws IllegalArgumentException {
        setName(name);
        setEgn(egn);
        setFacNumber(facNumber);
        setUniversity(university);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty!");

        this.name = name;
    }

    public String getEgn() {
        return this.egn;
    }

    public void setEgn(String eng) throws IllegalArgumentException {
        if (eng.length() != 10 || !eng.matches("\\d{10}"))
            throw new IllegalArgumentException("EGN must be exactly 10 digits");

        this.egn = eng;
    }

    public String getFacNumber() {
        return this.facNumber;
    }

    public void setFacNumber(String facNumber) {
        if (!facNumber.matches("^121222+\\d{3}$"))
            throw new IllegalArgumentException("Faculty number must match 121222 + 3 random digits!");

        this.facNumber = facNumber;
    }

    public String getUniversity() {
        return this.university;
    }

    public void setUniversity(String university) {
        for (String uniName: this.universities) {
            if (university.equals(uniName)) {
                this.university = university;
                return;
            }
        }

        throw new IllegalArgumentException("No such university found!");
    }

    public static Student registerStudent() {
        System.out.println("Register new student:");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String name = sc.nextLine();
        System.out.print("Enter student's EGN: ");
        String egn = sc.nextLine();
        System.out.print("Enter student's faculty number: ");
        String facNumber = sc.nextLine();
        System.out.print("Enter student's university: ");
        String university = sc.nextLine();

        try {
            return new Student(name, egn, facNumber, university);
        } catch (IllegalArgumentException e) {
            System.err.println("Error registering student: " + e.getMessage());
        }

        return null;
    }

    public static void changeUniversity(Map<String, String[]> studentsInfo) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Search student only by full name:");
        System.out.print("Enter: ");
        String name = sc.nextLine();

        String[] studentInfo = studentsInfo.get(name);
        if (studentInfo == null) {
            System.out.println("Error! No student with this name found!");
            return;
        }

        Student student = new Student(name, studentInfo[0], studentInfo[1], studentInfo[2]);

        System.out.print("Enter new university: ");
        String newUniversity = sc.nextLine();
        try {
            student.setUniversity(newUniversity);
        } catch (IllegalArgumentException e) {
            System.err.println("Error with university! " + e.getMessage());
        }

        studentsInfo.replace(name, new String[]{student.getEgn(), student.getFacNumber(), student.getUniversity()});

        System.out.println("University changed successfully.");
    }

    public static void dropUniversity(Map<String, String[]> studentsInfo) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Search student by 1) name; 2) egn; 3) faculty number:");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter search value: ");
        String searchValue = sc.nextLine();

        Iterator<Map.Entry<String, String[]>> iterator = studentsInfo.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = iterator.next();
            String key = entry.getKey();
            String[] studentInfo = entry.getValue();

            switch (choice) {
                case 1:
                    if (key.equals(searchValue)) {
                        iterator.remove();
                        System.out.println("Student " + searchValue + " successfully removed from university!");
                        return;
                    }
                    break;
                case 2:
                    for (String value : studentInfo) {
                        if (value.equals(searchValue)) {
                            iterator.remove();
                            System.out.println(
                                "Student with egn " + searchValue + " successfully removed from university!"
                            );
                            return;
                        }
                    }
                    break;
                case 3:
                    for (String value : studentInfo) {
                        if (value.equals(searchValue)) {
                            iterator.remove();
                            System.out.println(
                                "Student with faculty number " + searchValue + " successfully removed from university!"
                            );
                            return;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

        System.out.println("No student found with the specified search text!");
    }

    @Override
    public String toString() {
        return "Student's info:\nName: " + this.name + "\nEGN: " + this.egn +
               "\nFaculty number: " + this.facNumber + "\nUniversity: " + this.university;
    }
}
