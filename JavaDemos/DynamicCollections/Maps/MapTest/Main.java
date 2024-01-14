package MapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Employee {
    static int nextId = 0;
    int id = nextId++;
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

enum JobPosition {
    JUNIOR,
    MID,
    SENIOR,
    LEAD
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Employee, JobPosition> employees = initEmployees(sc);

        System.out.println("Employees:");
//        for (Employee employee : employees.keySet())
//            System.out.println(employee + ", " + employees.get(employee));

        employees.forEach((employee, position) -> System.out.println(employee + ", " + position));
    }

    public static Employee createEmployee(Scanner sc) {
        System.out.println("Create employee. Enter name and age...");
        String name = sc.nextLine();

        int age;
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Enter a valid integer.");
            }
        }

        return new Employee(name, age);
    }

    public static JobPosition choosePosition(Scanner sc) {
        System.out.println("Enter job position:");
        while (true) {
            try {
                return JobPosition.valueOf(sc.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid job position. Enter a valid position.");
            }
        }
    }

    public static Map<Employee, JobPosition> initEmployees(Scanner sc) {
        Map<Employee, JobPosition> employees = new HashMap<>();

        while (true) {
            employees.put(createEmployee(sc), choosePosition(sc));

            System.out.println("Init more employees? Y/N");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("Y"))
                return employees;
        }
    }
}