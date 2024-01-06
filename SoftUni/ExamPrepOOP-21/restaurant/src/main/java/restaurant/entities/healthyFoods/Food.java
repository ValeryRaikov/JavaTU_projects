package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.utils.DoubleUtils.LessEqualZeroCheck;
import static restaurant.utils.StringUtils.nullOrEmptyCheck;

public abstract class Food implements HealthyFood {
    private String name;
    private double portion;
    private double price;

    protected Food(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        nullOrEmptyCheck(name, INVALID_NAME);

        this.name = name;
    }

    public void setPortion(double portion) {
        LessEqualZeroCheck(portion, INVALID_PORTION);

        this.portion = portion;
    }

    public void setPrice(double price) {
        LessEqualZeroCheck(price, INVALID_PRICE);

        this.price = price;
    }
}
