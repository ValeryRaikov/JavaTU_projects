import java.util.Scanner;

public class FindAverage {
    public static void main(String[] args){
        int NUMBER = 7;

        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < NUMBER; ++i){
            System.out.print("Enter number[" + i + "]: ");
            sum += sc.nextInt();
        }

        float result = (float)sum / NUMBER;
        System.out.println("Average result is: " + result);
    }
}
