package MapReduceMethods;

import java.util.List;
import java.util.stream.Stream;

public class MapTest {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        Map method
        List<Integer> multnumbers = numbers.stream().map(n -> n * 10).toList();
        System.out.println("Print 1:");
        multnumbers.forEach(System.out::println);

        List<Integer> addNumbers = numbers.stream().map(n -> n + n).toList();
        System.out.println("Print 2:");
        addNumbers.forEach(System.out::println);

//        Reduce method
        int result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Print 3:");
        System.out.println(result);

        List<String> letters = List.of("a", "b", "c", "d", "e");
        String word = letters.stream().reduce("", (pString, el) -> pString + el);
        System.out.println("Print 4:");
        System.out.println(word);
    }
}
