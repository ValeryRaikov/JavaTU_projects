package OOP;

public class Breakfast extends BaseMeal {
    private int portionGrams;
    public Breakfast(String dishName, int caloriesCount, int portionGrams) {
        super(dishName, caloriesCount);
        setPortionGrams(portionGrams);
    }

    public int getPortionGrams() {
        return portionGrams;
    }

    public void setPortionGrams(int portionGrams) {
        this.portionGrams = portionGrams;
    }

    @Override
    public double calculateTotalCalories() {
        return (double) getPortionGrams() * getCaloriesCount() / 100;
    }

    @Override
    public boolean isHealthy() {
        double totalCalories = calculateTotalCalories();

        return totalCalories <= 300;
    }

    @Override
    public String toString() {
        return "Breakfast{" +
                "portionGrams=" + portionGrams +
                '}' + super.toString();
    }
}
