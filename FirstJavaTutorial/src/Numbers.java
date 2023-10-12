import java.util.Scanner;
import java.util.Arrays;

public class Numbers {
    public static void main(String[] args){
        int[] even_nums, odd_nums;
        int num_range;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your desired range to fill the arrays: ");
        while (true){
            num_range = sc.nextInt();

            if (num_range <= 0){
                System.out.print("Number should be positive. Try again: ");
            } else{
                break;
            }
        }
        even_nums = new int[num_range];
        odd_nums = new int[num_range];

        int a = 0, b = 0;
        int curr_num;
        while (a < num_range && b < num_range){
            System.out.print("Enter number: ");
            curr_num = sc.nextInt();

            if (curr_num % 2 == 0){
                even_nums[a] = curr_num;
                a++;
            } else{
                odd_nums[b] = curr_num;
                b++;
            }
        }
        if (even_nums.length == a){
            System.out.println("Even numbers array: " + Arrays.toString(even_nums));
        } else{
            System.out.println("Odd numbers array: " + Arrays.toString(odd_nums));
        }

    }
}
