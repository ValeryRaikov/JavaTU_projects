package OOP;

public class Lunch extends BaseMeal {
    private int portionGrams;
    public Lunch(String dishName, int caloriesCount, int portionGrams) {
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

        return totalCalories <= 500;
    }

    @Override
    public String toString() {
        return "Lunch{" +
                "portionGrams=" + portionGrams +
                '}' + super.toString();
    }
}

