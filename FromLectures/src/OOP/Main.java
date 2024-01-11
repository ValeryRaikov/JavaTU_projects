package OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Breakfast b1 = new Breakfast("Sandwiches", 114, 239);
        Breakfast b2 = new Breakfast("Pancakes", 147, 278);

        Lunch l1 = new Lunch("Pizza", 202, 200);
        Lunch l2 = new Lunch("Musaka", 76, 500);

        Dinner d1 = new Dinner("Meatballs", 111, 350);
        Dinner d2 = new Dinner("Fried meat", 186, 341);

        List<Breakfast> breakfasts = new ArrayList<>(Arrays.asList(b1, b2));
        List<Lunch> lunches = new ArrayList<>(Arrays.asList(l1, l2));
        List<Dinner> dinners = new ArrayList<>(Arrays.asList(d1, d2));

        breakfasts.forEach(breakfast -> {
            System.out.println("Breakfast: " + breakfast.getDishName());
            System.out.println("Total Calories: " + breakfast.calculateTotalCalories());
            System.out.println("Is Healthy: " + breakfast.isHealthy());
        });

        System.out.println();

        lunches.forEach(lunch -> {
            System.out.println("Lunch: " + lunch.getDishName());
            System.out.println("Total Calories: " + lunch.calculateTotalCalories());
            System.out.println("Is Healthy: " + lunch.isHealthy());
        });

        System.out.println();

        dinners.forEach(dinner -> {
            System.out.println("Dinner: " + dinner.getDishName());
            System.out.println("Total Calories: " + dinner.calculateTotalCalories());
            System.out.println("Is Healthy: " + dinner.isHealthy());
        });
    }
}
