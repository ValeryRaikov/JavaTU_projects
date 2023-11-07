import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> promoCodePromotion = new HashMap<>();

        // Promo Code: Discount percentage
        promoCodePromotion.put("loyal5", 5);
        promoCodePromotion.put("LOYAL10", 10);
        promoCodePromotion.put("magic15", 15);
        promoCodePromotion.put("MAGIC20", 20);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rods you want to store: ");
        int total = sc.nextInt();
        try {
            if (total <= 0)
                throw new Exception();
        }
        catch (Exception e) {
            System.err.println("Number must be positive!");
        }

        FishingRod[] rodCollection = new FishingRod[total];

        try {
            for (int i = 0; i < total; i++) {
                rodCollection[i] = FishingRod.createFishingRod(sc);
                rodCollection[i].printRodInfo();
            }
        }
        catch (EmptyFieldException | InvalidFieldException e) {
            System.err.println("Error! " + e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            System.err.println("Unexpected error!");
        }

        System.out.println("Fishing rods without discount:");
        for (int i = 0; i < total; i++) {
            System.out.println(rodCollection[i].getBrand() + " " + rodCollection[i].getModel() + " " + rodCollection[i].getPrice() + "lv.");
        }

        System.out.print("Enter promo code: ");
        sc.nextLine();
        String promoCode = sc.nextLine();

        if (promoCodePromotion.containsKey(promoCode)) {
            for (int i = 0; i < total; i++) {
                try {
                    rodCollection[i].getPromotion(promoCode, promoCodePromotion);
                }
                catch (KeyNotFoundException e) {
                    System.err.println("Error! " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Fishing rods with discount:");
        for (int i = 0; i < total; i++) {
            System.out.println(rodCollection[i].getBrand() + " " + rodCollection[i].getModel() + " " + rodCollection[i].getPrice() + "lv.");
        }

        FishingRod.printRodCollection(rodCollection);

        try {
            FishingRod.removeFishingRod(sc, rodCollection);
        }
        catch (Exception e) {
            System.err.println("Error!" + e.getMessage());
            e.printStackTrace();
        }

        try {
            FishingRod.changeFishingRod(sc, rodCollection);
        }
        catch (Exception e) {
            System.err.println("Error!" + e.getMessage());
            e.printStackTrace();
        }

        FishingRod.printRodCollection(rodCollection);

    }
}
