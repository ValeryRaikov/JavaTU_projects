import java.util.Scanner;

public class BreakWithLabel {
    public static void main(String[] args) {
        int[][] intArray = {
                {12, 15, 24, 30},
                {34, 45, 52, 58, 61},
                {67, 69, 75, 79, 88, 97},
                {104, 109, 133, 142}
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter int number to search for: ");
        int searchFor = sc.nextInt();

        boolean flag = false;
        search:
            for (int i = 0; i < intArray.length; i++) {
                for (int j = 0; j < intArray[i].length; j++) {
                    if (intArray[i][j] == searchFor) {
                        flag = true;
                        break search;
                    }
                }
            }
            if (flag) {
                System.out.println("Found " + searchFor + " in the array!");
            } else {
                System.out.println(searchFor + " is not in the array!");
            }

    }
}
