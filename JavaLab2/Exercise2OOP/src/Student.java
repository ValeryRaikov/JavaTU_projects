import java.util.Date;
public class Student extends People {
    private int facultyNumber;
    private double pikGrade;
    private double teGrade;
    private double ppeGrade;

    public Student(String name, Date birthDate, int facultyNumber, double pikGrade, double teGrade, double ppeGrade) {
        super(name, birthDate);
        this.facultyNumber = facultyNumber;
        this.pikGrade = pikGrade;
        this.teGrade = teGrade;
        this.ppeGrade = ppeGrade;
    }

    public int getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(int facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public double getPikGrade() {
        return pikGrade;
    }

    public void setPikGrade(double pikGrade) {
        this.pikGrade = pikGrade;
    }

    public double getTeGrade() {
        return teGrade;
    }

    public void setTeGrade(double teGrade) {
        this.teGrade = teGrade;
    }

    public double getPpeGrade() {
        return ppeGrade;
    }

    public void setPpeGrade(double ppeGrade) {
        this.ppeGrade = ppeGrade;
    }

    public void takeExam(double pikGrade, double teGrade, double ppeGrade) {
        this.pikGrade = pikGrade;
        this.teGrade = teGrade;
        this.ppeGrade = ppeGrade;
    }
}