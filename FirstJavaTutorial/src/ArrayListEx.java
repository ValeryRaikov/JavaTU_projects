// Demonstration of java ArrayList and it's methods

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of cars you want to store: ");
        int num = sc.nextInt();

        sc.nextLine();

        while (num <= 0) {
            System.out.print("Wrong input. Number must be positive... Try again: ");
            num = sc.nextInt();

            sc.nextLine();
        }

        for (int i = 0; i < num; ++i) {
            System.out.print("Enter car [" + i + "]: ");
            // Add method
            cars.add(sc.nextLine());
        }

        // Add more cars
        cars.add("Volvo");

        boolean bentleyPresent = false;
        for (String carBrand : cars) {
            if (carBrand.equals("Bentley")) {
                bentleyPresent = true;
                break;
            }
        }

        if (bentleyPresent) {
            System.out.println("Bentley is already present");
        } else {
            cars.add("Bentley");
            System.out.println("Bentley added");
        }

        System.out.println(cars);

        // Get method
        System.out.println(cars.get(0));

        // Set method
        cars.set(0, "Toyota");
        cars.set(2, "Volkswagen");

        // Remove method
        cars.remove(0);
        cars.remove(1);

        // Size method
        System.out.println("Array size is: " + cars.size());

        // Clear the cars array
        //cars.removeFirst();
        cars.clear();

        // Create new ArrayList of integer numbers
        ArrayList<Integer> nums = new ArrayList<Integer>();
        System.out.println("Enter 4 numbers: ");
        nums.add(sc.nextInt());
        nums.add(sc.nextInt());
        nums.add(sc.nextInt());
        nums.add(sc.nextInt());

        System.out.print("Numbers are: ");
        for (int i : nums) {
            System.out.print(i + "\t");
        }

        System.out.println();

        // Sort the numbers list
        Collections.sort(nums.reversed());
        System.out.print("Reversed sorted numbers are: ");
        for (int i : nums) {
            System.out.print(i + "\t");
        }
    }
}