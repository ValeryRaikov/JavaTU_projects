package RegularExamRetry;

public class Grade {
    private String subject;
    private int semesterNumber;
    private int grade;

    public Grade(String subject, int semesterNumber, int grade) {
        setSubject(subject);
        setSemesterNumber(semesterNumber);
        setGrade(grade);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("Grade -> subject: %s, semester: %d, grade: %d",
                getSubject(), getSemesterNumber(), getGrade());
    }
}
