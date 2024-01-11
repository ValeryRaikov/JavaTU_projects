package OOP;

public abstract class BaseMeal {
    private static final MealType type = MealType.BASE_MEAL;
    private String dishName;
    private int caloriesCount;

    public BaseMeal(String dishName, int caloriesCount) {
        setDishName(dishName);
        setCaloriesCount(caloriesCount);
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getCaloriesCount() {
        return caloriesCount;
    }

    public void setCaloriesCount(int caloriesCount) {
        this.caloriesCount = caloriesCount;
    }

    public abstract double calculateTotalCalories();
    public abstract boolean isHealthy();

    @Override
    public String toString() {
        return String.format("Meal: %s; Type: %s; Calories: %d.", getDishName(), BaseMeal.type, getCaloriesCount());
    }
}
