import java.util.Arrays;
import java.util.Scanner;

public class JavaArrays {
    public static void main(String[] args){
        int[] firstArr = {1, 2, 3, 4, 5};
        float[] secondArr = {1.25f, 3.75f, 10.5f};
        String[] thirdArr = {"This", "is", "string", "array"};

        //Easiest way to print values on the console
        System.out.print("First Array: ");
        for (int i = 0; i < firstArr.length; ++i){
            System.out.print(firstArr[i] + "\t");
        }
        System.out.println();

        System.out.print("Second Array: ");
        for (int i = 0; i < secondArr.length; ++i){
            System.out.print(secondArr[i] + "\t");
        }
        System.out.println();

        System.out.print("Third Array: ");
        for (int i = 0; i < thirdArr.length; ++i){
            System.out.print(thirdArr[i] + "\t");
        }
        System.out.println();
        
        //For-each loop to print array values
        for (int num: firstArr) {
            System.out.print(num + "\s");
        }
        System.out.println();

        for (String word: thirdArr) {
            System.out.print(word + "\s");
        }
        System.out.println();

        //Arrays.toString() method usage
        System.out.println(Arrays.toString(firstArr));
        System.out.println(Arrays.toString(secondArr));
        System.out.println(Arrays.toString(thirdArr));

        //Fill an array with user input values
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements you want to store: ");
        int number = sc.nextInt();
        int[] testArr = new int[number];
        for (int i = 0; i < number; ++i){
            System.out.print("Enter[" +  i + "] element: ");
            testArr[i] = sc.nextInt();
        }
        System.out.print("You created the following array: ");
        System.out.println(Arrays.toString(testArr));

        //Find max/min values of an int array
        int max = testArr[0];
        for (int i = 1; i < testArr.length; ++i){
            if (testArr[i] > max){
                max = testArr[i];
            }
        }
        System.out.println("Max value is: " + max);

        int min = testArr[0];
        for (int i = 1; i < testArr.length; ++i){
            if (testArr[i] < min){
                min = testArr[i];
            }
        }
        System.out.println("Min value is: " + min);

    }
}