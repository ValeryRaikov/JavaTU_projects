package OOP;

public class Dinner extends BaseMeal {
    private int portionGrams;
    public Dinner(String dishName, int caloriesCount, int portionGrams) {
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

        return totalCalories <= 400;
    }

    @Override
    public String toString() {
        return "Dinner{" +
                "portionGrams=" + portionGrams +
                '}' + super.toString();
    }
}
