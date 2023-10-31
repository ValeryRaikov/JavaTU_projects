import java.util.Scanner;
import java.util.InputMismatchException;

class ValueTooSmall extends Exception {
    public ValueTooSmall(String message) {
        super(message);
    }
}

class ValueTooBig extends Exception {
    public ValueTooBig(String message) {
        super(message);
    }
}

public class Exc2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a whole number for your age: ");

        try {
            int age = sc.nextInt();

            if (age <= 0) {
                throw new ValueTooSmall("Age cannot be that small!");
            } else if (age >= 100) {
                throw new ValueTooBig("Age cannot be that big!");
            }

            // Close the Scanner after use to release resources
            sc.close();

            System.out.println("Your age is: " + age);
        }
        catch (ValueTooSmall e) {
            System.out.println(e.getMessage());
        }
        catch (ValueTooBig e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong user input! Integer required.");
        }
        catch (Exception e) {
            System.out.println("Unexpected error occurred!");
        }
    }
}