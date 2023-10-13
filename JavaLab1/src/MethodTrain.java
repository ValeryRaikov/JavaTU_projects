import java.util.Scanner;

public class MethodTrain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        getPerson(sc);
        float totalIncome = calculateSalary(sc);
        float diff = checkSalary(totalIncome);
        System.out.println("Difference in your state is: " + diff);
    }

    public static void getPerson(Scanner sc) {
        System.out.println("Hello there! Please fill the current fields...");
        System.out.print("1) Enter your full name: ");
        String name = sc.nextLine();

        System.out.print("2)Enter your age: ");
        int age;
        while (true) {
            age = sc.nextInt();
            if (age <= 0) {
                System.out.print("Wrong user input! Try again: ");
            } else {
                break;
            }
        }
        sc.nextLine();

        System.out.print("3)Enter your current course: ");
        String course = sc.nextLine();

        System.out.println();
        System.out.printf("Hello (%s, %d). Good luck with (%s).", name, age, course);
        System.out.println();
    }

    public static float calculateSalary(Scanner sc) {
        System.out.print("Enter your monthly salary: ");
        float salary = sc.nextFloat();

        float yearSalary = salary * 12;
        return yearSalary;
    }

    public static float checkSalary(float salary) {
        float diff;
        if (salary >= 72000) {
            System.out.println("Super Wealthy!");
            diff = salary - 72000;
        } else if (salary >= 42000) {
            System.out.println("Wealthy!");
            diff = salary - 42000;
        } else if (salary >= 24000) {
            System.out.println("Normal!");
            diff = salary - 24000;
        } else {
            System.out.println("Normal to Poor!");
            diff = salary - 24000;
        }

        return diff;
    }

}