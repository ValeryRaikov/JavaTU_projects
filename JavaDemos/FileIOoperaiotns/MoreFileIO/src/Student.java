import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String EGN;
    private String faculty;
    private String specialty;

    public Student(String fName, String lName, Date bDate, String egn, String fac, String spec) {
        setFirstName(fName);
        setLastName(lName);
        setBirthDate(bDate);
        setEGN(egn);
        setFaculty(fac);
        setSpecialty(spec);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newFName) {
        if (newFName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty!");
        }

        this.firstName = newFName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String newLName) {
        if (newLName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty!");
        }

        this.lastName = newLName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date newBDate) {
        if (newBDate.after(new Date())) {
            throw new IllegalArgumentException("Birth date cannot be in the future!");
        }

        this.birthDate = newBDate;
    }

    public String getEGN() {
        return this.EGN;
    }

    public void setEGN(String newEGN) {
        if (!newEGN.matches("\\d{10}")) {
            throw new IllegalArgumentException("EGN must contain exactly 10 digits!");
        }

        this.EGN = newEGN;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String newFac) {
        if (newFac.isEmpty()) {
            throw new IllegalArgumentException("Faculty cannot be empty!");
        }

        this.faculty = newFac;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String newSpec) {
        if (newSpec.isEmpty()) {
            throw new IllegalArgumentException("Specialty cannot be empty!");
        }

        this.specialty = newSpec;
    }
}
