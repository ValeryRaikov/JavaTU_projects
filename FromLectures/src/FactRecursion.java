public class FactRecursion {
    public static void main(String[] args) {
        System.out.println("Find the factorial of 5:");

        System.out.println(factorial(5));
    }

    public static int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number -1);
    }
}
