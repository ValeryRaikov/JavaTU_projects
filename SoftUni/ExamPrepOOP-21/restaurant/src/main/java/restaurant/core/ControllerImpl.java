package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import java.util.Collection;

public class ControllerImpl implements Controller {


    private final HealthFoodRepository<HealthyFood> healthFoodRepository;
    private final BeverageRepository<Beverages> beverageRepository;
    private final TableRepository<Table> tableRepository;

    private double totalIncome;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository,
                          BeverageRepository<Beverages> beverageRepository,
                          TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = type.equals("Salad") ? new Salad(name, price): new VeganBiscuits(name, price);

        HealthyFood previouslyAddedFood = this.healthFoodRepository.foodByName(name);

        if (previouslyAddedFood == null) {
            this.healthFoodRepository.add(food);
            return String.format(OutputMessages.FOOD_ADDED, name);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        Beverages beverage = type.equals("Smoothie") ? new Smoothie(name, counter, brand): new Fresh(name, counter, brand);

        Beverages previouslyAddedBeverages = this.beverageRepository.beverageByName(name, brand);

        if (previouslyAddedBeverages == null) {
            this.beverageRepository.add(beverage);
            return String.format(OutputMessages.BEVERAGE_ADDED, name, brand);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = type.equals("InGarden") ? new InGarden(tableNumber, capacity): new Indoors(tableNumber, capacity);

        Table previouslyAddedTables = this.tableRepository.byNumber(tableNumber);

        if (previouslyAddedTables == null) {
            this.tableRepository.add(table);
            return String.format(OutputMessages.TABLE_ADDED, tableNumber);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
    }

    @Override
    public String reserve(int numberOfPeople) {
        Collection<Table> tables = this.tableRepository.getAllEntities();

        for (Table table: tables) {
            if (table.getSize() >= numberOfPeople && !table.isReservedTable()) {
                table.reserve(numberOfPeople);
                return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }

        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);

        if (table == null)
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);

        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);

        if (food == null)
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);

        table.orderHealthy(food);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);

        if (table == null)
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);

        Beverages drink = beverageRepository.beverageByName(name, brand);

        if (drink == null)
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);

        table.orderBeverages(drink);
        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);

        double bill = table.bill();
        table.clear();

        totalIncome += bill;

        return String.format(OutputMessages.BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(OutputMessages.TOTAL_MONEY, totalIncome);
    }
}
