import java.util.Scanner;

public class Loops {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);

        System.out.print("Enter the number of iterations you want: ");
        int number = sc.nextInt();

        //For loop
        for (int i = 0; i < number; ++i){
            System.out.println(i);
        }

        for (int i = 1; i <= number; ++i){
            System.out.println("[" + i + "]" + " iteration");
        }

        //While loop
        int i = 0;
        while (i < number){
            System.out.println("Learning while loops");
            ++i;
        }

        //Do-while loop
        int j = 0;
        int constVal = 100;
        do{
            System.out.println(j + constVal);
            ++j;
        } while (j < number);
    }
}
