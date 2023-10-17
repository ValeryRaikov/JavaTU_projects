public class Course {
    private String courseName;

    public Course() {
        this.courseName = "";
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
