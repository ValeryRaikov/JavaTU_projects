package EStudent;

import java.util.*;

public class Student {
    private String name;
    private int year;
    private Map<Subject, List<Grade>> gradeBook;
    private Map<Subject, Integer> absenceBook;
    private static List<Student> excludedStudents = new ArrayList<>();

    public Student(String name, int year) {
        setName(name);
        setYear(year);
        gradeBook = new HashMap<>();
        absenceBook = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Map<Subject, List<Grade>> getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(Map<Subject, List<Grade>> gradeBook) {
        this.gradeBook = gradeBook;
    }

    public Map<Subject, Integer> getAbsenceBook() {
        return absenceBook;
    }

    public void setAbsenceBook(Map<Subject, Integer> absenceBook) {
        this.absenceBook = absenceBook;
    }

    public static void setExcludedStudents(List<Student> excludedStudents) {
        Student.excludedStudents = excludedStudents;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", gradeBook=" + gradeBook +
                ", absenceBook=" + absenceBook +
                '}';
    }

    public static List<Student> initStudents() {
        return List.of(
                new Student("Valery Raikov", 10),
                new Student("Lili Vasilevska", 8),
                new Student("Nikolai Haitov", 11),
                new Student("Dimitar Asenov", 11),
                new Student("Andrea Nasteva", 12)
        );
    }

    public void addSubjectsToStudentBook(List<Subject> subjects) {
        for (Subject subject : subjects) {
            if (getGradeBook().containsKey(subject) && getAbsenceBook().containsKey(subject)) {
                System.out.format("Subject %s already added to the student collection!\n", subject);
                continue;
            }

            System.out.format("Added subject %s to the student collection!\n", subject);

            gradeBook.put(subject, new ArrayList<>());
            absenceBook.put(subject, 0);
        }
    }

    public Map<Subject, List<Grade>> addGradesToGradeBook(Subject subject, List<Grade> grades) {
        if (!getGradeBook().containsKey(subject)) {
            System.out.format("No subject %s in the student collection!\n", subject);
            return gradeBook;
        }

        for (Grade grade : grades) {
            if (getGradeBook().get(subject).size() > 5) {
                System.out.println("Student cannot have more than 5 grades per subject!");
                break;
            }

            gradeBook.get(subject).add(grade);
        }

        return gradeBook;
    }

    public Map<Subject, Integer> addAbsenceToAbsenceBook(Subject subject, int absenceCount) {
        if (!getAbsenceBook().containsKey(subject)) {
            System.out.format("No subject %s in the student collection!\n", subject);
            return absenceBook;
        }

        if (checkAbsenceCount(subject)) {
            absenceBook.put(subject, absenceCount);
        }

        excludeStudent();
        return absenceBook;
    }

    private boolean checkAbsenceCount(Subject subject) {
        if (!getAbsenceBook().containsKey(subject)) {
            System.out.format("No subject %s in the student collection!\n", subject);
            return false;
        }

        if (getAbsenceBook().get(subject) > 10) {
            System.out.println("Student has too many absences and cannot finish the semester!");

            return false;
        }

        return true;
    }

    public void excludeStudent() {
        for (int absence: getAbsenceBook().values()) {
            if (absence > 10) {
                System.out.println(this + " is excluded from class!");
            }
        }

        excludedStudents.add(this);
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        List<Student> students = initStudents();

        while (true) {
            System.out.println("Enter student name to perform operations:");
            String name = sc.nextLine();

            boolean studentFound = false;
            for (Student student : students) {
                if (name.equalsIgnoreCase(student.getName())) {
                    System.out.println("Found student...");

                    System.out.println("""
                            Select operation:
                            1 -> assign subjects to student
                            2 -> add grade to student grade book
                            3 -> add absence to student absence book
                            (Other) -> Exit program
                            """);

                    int command = Integer.parseInt(sc.nextLine());

                    switch (command) {
                        case 1:
                            System.out.println("Enter subjects - (use ', ' delimiter):");
                            List<String> subjectNames = List.of(sc.nextLine().split(", "));

                            List<Subject> subjects = new ArrayList<>();
                            for (String currSubjectName: subjectNames) {
                                subjects.add(new Subject(currSubjectName));
                            }

                            addSubjectsToStudentBook(subjects);
                            break;
                        case 2:
                            System.out.println("Enter grades - (use ', ' delimiter):");
                            List<Double> gradeValues = Arrays.asList(sc.nextLine().split(", ")).stream()
                                    .map(Double::parseDouble)
                                    .toList();

                            System.out.println("Enter subject: ");
                            String subjectNameForGrade = sc.nextLine();

                            Subject subjectToAddGrade = new Subject(subjectNameForGrade);
                            List<Grade> grades = gradeValues.stream().map(Grade::new).toList();

                            addGradesToGradeBook(subjectToAddGrade, grades);
                            break;
                        case 3:
                            System.out.println("Enter absence count:");
                            int absenceCount = Integer.parseInt(sc.nextLine());

                            System.out.println("Enter subject: ");
                            String subjectNameForAbsence = sc.nextLine();

                            Subject subjectToAddAbsence = new Subject(subjectNameForAbsence);

                            addAbsenceToAbsenceBook(subjectToAddAbsence, absenceCount);
                            break;
                        default:
                            System.out.println("Exiting program...");
                            return;
                    }

                    studentFound = true;
                    break;
                }
            }

            if (!studentFound)
                System.out.println("No such student found in the system!");

        }
    }
}