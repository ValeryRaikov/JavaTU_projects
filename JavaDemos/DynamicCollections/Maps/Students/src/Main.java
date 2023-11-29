import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String[]> studentsInfo = new HashMap<>();

        System.out.print("Enter the number of students to register: ");
        int total = sc.nextInt();
        for (int i = 0; i < total; i++) {
            Student currentStudent = Student.registerStudent();

            if (currentStudent != null) {
                String name = currentStudent.getName();
                String egn = currentStudent.getEgn();
                String facNumber = currentStudent.getFacNumber();
                String university = currentStudent.getUniversity();

                System.out.println(currentStudent.toString());

                studentsInfo.put(name, new String[]{egn, facNumber, university});
            } else {
                System.out.println("Error with student!");
            }
        }

        System.out.println("Change student's university:");
        Student.changeUniversity(studentsInfo);

        System.out.println("Remove student from university:");
        Student.dropUniversity(studentsInfo);

        System.out.println("Students in the system:");
        for (Map.Entry<String, String[]> entry : studentsInfo.entrySet()) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            System.out.println("Name: " + name + ", EGN: " + values[0] + ", FacNumber: " + values[1] + ", University: " + values[2]);
        }

    }
}
