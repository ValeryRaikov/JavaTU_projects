package EStudent;

public class Grade {
    private double gradeValue;

    public Grade(double gradeValue) {
        setGradeValue(gradeValue);
    }

    public double getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(double gradeValue) {
        this.gradeValue = gradeValue;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeValue=" + gradeValue +
                '}';
    }
}
