import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //First glimpse of the language
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your sentence: ");
        String sentence = sc.nextLine();
        System.out.println("This is your sentence: " + sentence);

        String[] arr = {"Ivan", "Georgi", "Peter"};
        for (String s: arr){
            System.out.println(s);
        }

        int i = 1;
        toStringMethod(i);
        System.out.println(i);

        int[] numbers = {1, 2, 3};
        toStringMethod(numbers);
        System.out.println(Arrays.toString(numbers));
    }

        public static void toStringMethod(int x){
            x = 1000;
        }

        public static void toStringMethod(int[] b){
            for (int i = 0; i < b.length; ++i){
                b[i]++;
            }
        }

    }