import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        System.out.println("The purpose of this program is to calculate the area of different figures...");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter figure:\n1-square\n2-rectangle\n3-triangle\n4-circle");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter square side: ");
                System.out.println("Area is " + squareArea(sc.nextInt()) + "cm^2");
                break;
            case 2:
                System.out.print("Enter rectangle length and height: ");
                System.out.println("Area is " + rectangleArea(sc.nextInt(), sc.nextInt()) + "cm^2");
                break;
            case 3:
                System.out.println("Enter triangle side and height: ");
                System.out.println("Area is " + triangleArea(sc.nextInt(), sc.nextInt()) + "cm^2");
                break;
            case 4:
                System.out.println("Enter circle radius: ");
                System.out.println("Area is " + circleArea(sc.nextInt()) + "cm^2");
                break;
            default:
                System.err.println("Invalid user input!");
                break;
        }
    }

    public static int squareArea(int a) {
        return (int) Math.pow(a, 2);
    }

    public static int rectangleArea(int a, int b) {
        return a * b;
    }

    public static double triangleArea(int a, int ha) {
        return (double) a * ha / 2;
    }

    public static double circleArea(int r) {
        return Math.PI * Math.pow(r, 2);
    }

}
