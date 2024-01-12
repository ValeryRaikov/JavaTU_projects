package EStudent;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Student.initStudents();

        for(Student student: students) {
            student.menu();
        }
    }
}
