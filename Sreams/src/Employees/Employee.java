package Employees;

public class Employee {
    private static int nextId = 0;
    private String firstName;
    private String lastName;
    private int id;
    private EmployeeType employeeType;

    public Employee(String firstName, String lastName, EmployeeType employeeType) {
        setFirstName(firstName);
        setLastName(lastName);
        setId(nextId+=1);
        setEmployeeType(employeeType);
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return String.format("Employees.Employee -> %s %s with ID: %d is on %s position",
                getFirstName(), getLastName(), getId(), getEmployeeType());
    }
}
