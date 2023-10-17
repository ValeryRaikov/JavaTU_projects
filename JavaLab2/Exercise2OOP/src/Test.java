import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("Ivan Ivanov", new Date(), 12345, 4.5, 5.0, 3.2);

        System.out.println("Student name: " + student.getName());
        System.out.println("Faculty number: " + student.getFacultyNumber());
        System.out.println("PIK grade: " + student.getPikGrade());
        System.out.println("TE grade: " + student.getTeGrade());
        System.out.println("PPE grade: " + student.getPpeGrade());

        student.takeExam(4.8, 4.9, 3.5);
        System.out.println("New grades are: PIK - " + student.getPikGrade() + ", TE - " + student.getTeGrade() + ", PPE - " + student.getPpeGrade());
    }
}