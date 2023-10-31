import java.util.InputMismatchException;
import java.util.Scanner;

public class Exc1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a whole number to divide: ");
            int a = sc.nextInt();

            System.out.print("Enter a number to divide by: ");
            int b = sc.nextInt();

            int res = a / b;
            System.out.println("Result is: " + res);
        }
        catch (ArithmeticException e) {
            System.out.println("Division by zero is not possible!");
        }
        catch (InputMismatchException e) {
            System.out.println("Divisor must be of type int!");
        }
        catch (Exception e) {
            System.out.println("Unexpected error!");
        }
        finally {
            System.out.println("Goodbye!");
        }
    }
}
