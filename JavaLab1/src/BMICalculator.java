import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        printIntroduction();
        float index = getBMI(sc);
        String status = getStatus(index);
        reportResults(1, index, status);

    }

    public static void printIntroduction(){
        System.out.println("This is the BMI calculator program that calculates your BMI index!!!");
    }

    public static float getBMI(Scanner sc){
        System.out.print("Enter your weight in pounds: ");
        float weight = sc.nextFloat();
        System.out.print("Enter your height in inches: ");
        float height = sc.nextFloat();

        return bmiFor(weight, height);
    }

    public static float bmiFor(float weight, float height){
        float bodyMassIndex = weight * 703 / (height * height);

        return bodyMassIndex;
    }

    public static String getStatus(float index){
        String status;
        if (index > 30) {
            status = "Obese";
        } else if (index > 25) {
            status = "Overweight";
        }else if (index > 18.5){
            status = "Normal";
        } else {
            status = "Underweight";
        }

        return status;
    }

    public static void reportResults(int number, float bmiIndex, String status){
        System.out.printf("Person (№%d) with BMI index of %f is with status %s!", number, bmiIndex, status);
    }

}