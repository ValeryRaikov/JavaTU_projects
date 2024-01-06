package restaurant.entities.drinks;

import restaurant.entities.drinks.interfaces.Beverages;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.utils.DoubleUtils.LessEqualZeroCheck;
import static restaurant.utils.IntegerUtils.LessEqualZeroCheck;
import static restaurant.utils.StringUtils.nullOrEmptyCheck;

public abstract class BaseBeverage implements Beverages {
    private String name;
    private int counter;
    private double price;
    private String brand;

    protected BaseBeverage(String name, int counter, double price, String brand) {
        setName(name);
        setCounter(counter);
        setPrice(price);
        setBrand(brand);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getBrand() {
        return brand;
    }



    public void setName(String name) {
        nullOrEmptyCheck(name, INVALID_NAME);

        this.name = name;
    }

    public void setCounter(int counter) {
        LessEqualZeroCheck(counter, INVALID_COUNTER);

        this.counter = counter;
    }

    public void setPrice(double price) {
        LessEqualZeroCheck(price, INVALID_PRICE);

        this.price = price;
    }

    public void setBrand(String brand) {
        nullOrEmptyCheck(brand, INVALID_BRAND);

        this.brand = brand;
    }
}
