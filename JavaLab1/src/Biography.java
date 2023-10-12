import java.util.Scanner;

public class Biography {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("This is your biography program: ");

        String[] arr = new String[4];

        System.out.print("Enter your full name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        String age = sc.nextLine();
        System.out.print("Enter your university: ");
        String university = sc.nextLine();
        System.out.print("Enter your specialty: ");
        String specialty = sc.nextLine();

        arr[0] = name;
        arr[1] = age;
        arr[2] = university;
        arr[3] = specialty;

        for (String s: arr) {
            System.out.println(s);
        }
    }
}
