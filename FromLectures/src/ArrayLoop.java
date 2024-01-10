import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers:");
        for (int i = 0; i < 5; i++) {
            numbers.add(sc.nextInt());
        }

        System.out.println("This is your array: ");
        numbers.forEach(System.out::println);
    }
}
