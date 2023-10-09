import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.print("Enter mathematical operator: ");
        char operator = sc.next().charAt(0);

        float result;
        switch (operator){
            case '+':
                result = a + b;
                System.out.println("Result of addition is: " + result);
                break;
            case '-':
                result = a - b;
                System.out.println("Result of subtraction is: " + result);
                break;
            case '*':
                result = a * b;
                System.out.println("Result of multiplication is: " + result);
                break;
            case '/':
                if (b != 0) {
                    result = (float) a / b;
                    System.out.println("Result of division is: " + result);
                } else {
                    System.out.println("Division by zero is impossible!");
                }
                    break;
            default:
                System.out.println("Wrong user input!");
        }
    }
}