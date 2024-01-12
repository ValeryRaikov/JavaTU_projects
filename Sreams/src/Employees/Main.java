package Employees;//Program to test Java Collections Stream API

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Mihail", "Andonov", EmployeeType.MID),
                new Employee("Petko", "Totev", EmployeeType.MANAGER),
                new Employee("Anna", "Todorova", EmployeeType.JUNIOR),
                new Employee("Ivailo", "Martinov", EmployeeType.JUNIOR),
                new Employee("Valentin", "Blagoev", EmployeeType.SENIOR),
                new Employee("Ksenia", "Angelova", EmployeeType.MID),
                new Employee("Kristina", "Kuncheva", EmployeeType.SENIOR),
                new Employee("Maria", "Motovska", EmployeeType.LEAD),
                new Employee("Georgi", "Georgiev", EmployeeType.LEAD),
                new Employee("Ivan", "Stankov", EmployeeType.SENIOR),
                new Employee("Vanesa", "Velkova", EmployeeType.MANAGER),
                new Employee("Vasil", "Penev", EmployeeType.JUNIOR)
                );

//        Filter

        List<Employee> seniorFilter = employees.stream().filter(
                employee -> employee.getEmployeeType().equals(EmployeeType.SENIOR)
        ).toList();

        System.out.println("Senior employees:");
        seniorFilter.forEach(System.out::println);

        List<Employee> nameFilter = employees.stream().filter(
                employee -> employee.getFirstName().startsWith("V")
        ).toList();

        System.out.println();
        System.out.println("Employees whose name starts with 'V':");
        nameFilter.forEach(System.out::println);

//        Sort
        List<Employee> nameSortAsc = employees.stream().sorted(
                Comparator.comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName)
        ).toList();

        System.out.println();
        System.out.println("Sorted employees by first and last name:");
        nameSortAsc.forEach(System.out::println);

        List<Employee> typeSortDesc = employees.stream().sorted(
                Comparator.comparing(Employee::getEmployeeType).reversed()
        ).toList();

        System.out.println();
        System.out.println("Sorted employees by type:");
        typeSortDesc.forEach(System.out::println);

        List<Employee> idSortAsc = employees.stream().sorted(
                Comparator.comparing(Employee::getId)
        ).toList();

        System.out.println();
        System.out.println("Sorted employees by ID:");
        idSortAsc.forEach(System.out::println);

//        Any match
        boolean juniorFound = employees.stream().anyMatch(
                employee -> employee.getEmployeeType().equals(EmployeeType.JUNIOR)
        );

        System.out.println();
        if (juniorFound)
            System.out.println("There are juniors in the collection!");
        else
            System.out.println("There are no juniors in the collection!");

//        None match
        boolean LeadFound = employees.stream().noneMatch(
                employee -> employee.getEmployeeType().equals(EmployeeType.LEAD)
        );

        System.out.println();
        if (!LeadFound)
            System.out.println("There are leads in the collection!");
        else
            System.out.println("There are no leads in the collection!");

//        Group
        Map<EmployeeType, List<Employee>> groupByType = employees.stream().collect(
                Collectors.groupingBy(Employee::getEmployeeType)
        );

        System.out.println();
        System.out.println("Employees by position: ");
        groupByType.forEach((employeeType, employee1) -> {
            System.out.println(employeeType);
            employee1.forEach(System.out::println);
        });
    }
}
