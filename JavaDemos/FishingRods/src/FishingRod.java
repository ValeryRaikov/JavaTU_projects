import java.util.HashMap;
import java.util.Scanner;

public class FishingRod {
    private String brand;
    private String model;
    private String type;
    private double length;
    private double price;
    private double rating;
    private boolean isAvailable = true;

    public FishingRod(String brand, String model, String type, double length, double price, double rating)  {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.length = length;
        this.price = price;
        this.rating = rating;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String newBrand) throws EmptyFieldException {
        if (newBrand.isEmpty())
            throw new EmptyFieldException("Brand error! ");

        this.brand = newBrand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String newModel) throws EmptyFieldException {
        if (newModel.isEmpty())
            throw new EmptyFieldException("Model error! ");

        this.model = newModel;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String newType) throws EmptyFieldException {
        if (newType.isEmpty())
            throw new EmptyFieldException("Type error! ");

        this.type = newType;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double newLength) throws InvalidFieldException {
        if (newLength < 1.5 || newLength > 7.0) {
            throw new InvalidFieldException("Length error! ");
        }

        this.length = newLength;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) throws InvalidFieldException {
        if (newPrice < 29.99 || newPrice > 900.0) {
            throw new InvalidFieldException("Price error! ");
        }

        this.price = newPrice;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double newRating) throws InvalidFieldException {
        if (newRating < 0 || newRating > 10.0) {
            throw new InvalidFieldException("Rating error! ");
        }

        this.rating = newRating;
    }

    public static FishingRod createFishingRod(Scanner sc) throws EmptyFieldException, InvalidFieldException {
        System.out.println("Fishing rod creator:");
        sc.nextLine();

        System.out.print("Enter rod brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter rod model: ");
        String model = sc.nextLine();
        System.out.print("Enter rod type: ");
        String type = sc.nextLine();
        System.out.print("Enter rod length: ");
        double length = sc.nextDouble();
        System.out.print("Enter rod price: ");
        double price = sc.nextDouble();
        System.out.print("Enter rod rating: ");
        double rating = sc.nextDouble();

        if (brand.isEmpty() || model.isEmpty() || type.isEmpty())
            throw new EmptyFieldException("Rod creation error!");

        if ((length < 1.5 || length > 7.0) || (price < 29.99 || price > 900.0) || (rating < 0 || rating > 10.0))
            throw  new InvalidFieldException("Rod creation error!");

        return new FishingRod(brand, model, type, length, price, rating);
    }

    public void outOfStock() {
        this.isAvailable = false;
    }

    public void getPromotion(String promoCode, HashMap<String, Integer>promoCodePromotion) throws KeyNotFoundException {
        if (!promoCodePromotion.containsKey(promoCode))
            throw new KeyNotFoundException("Promo code error! ");

        this.price *= (double)(100 - promoCodePromotion.get(promoCode)) / 100;
    }

    public void printRodInfo() {
        System.out.println("Fishing rod: " + this.brand + " " + this.model + "\nType: " + this.type + "\nLength: " + this.length + "\nPrice: " + this.price + "\nRating: " + this.rating);
    }

    public static void printRodCollection(FishingRod[] rodCollection) {
        System.out.println("Fishing rods in the collection:");

        for (int i = 0; i < rodCollection.length; i++) {
            System.out.println(rodCollection[i].getBrand() + " " + rodCollection[i].getModel());
        }
    }

    public static void removeFishingRod(Scanner sc, FishingRod[] rodCollection) throws Exception {
        System.out.println("Enter fishing rod brand to remove: ");
        String brandToRemove = sc.nextLine();
        System.out.println("Enter fishing rod model to remove: ");
        String modelToRemove = sc.nextLine();

        for (int i = 0; i < rodCollection.length; i++) {
            if (rodCollection[i].getBrand().equals(brandToRemove) && rodCollection[i].getModel().equals(modelToRemove)) {
                System.arraycopy(rodCollection, i + 1, rodCollection, i, rodCollection.length - 1 - i);
                rodCollection[rodCollection.length - 1] = null;
                System.out.println("Fishing rod removed.");
                return;
            }
        }

        throw new Exception("Fishing rod not found in the collection.");
    }

    public static void changeFishingRod(Scanner sc, FishingRod[] rodCollection) throws Exception {
        System.out.println("Enter fishing rod brand: ");
        String brand = sc.nextLine();
        System.out.println("Enter fishing rod model: ");
        String model = sc.nextLine();

        for (int i = 0; i < rodCollection.length; i++) {
            if (rodCollection[i].getBrand().equals(brand) && rodCollection[i].getModel().equals(model)) {
                System.out.println("Edit the following fishing rod: ");
                rodCollection[i].printRodInfo();
                rodCollection[i] = FishingRod.createFishingRod(sc);
                System.out.println("Successfully edited fishing rod! New one is: ");
                rodCollection[i].printRodInfo();

                return;
            }
        }

        throw new Exception("Fishing rod not found in the collection.");
    }

}
