public class Main {
    public static void main(String[] args) {
        Car car = new Car(200, "Car Model", 25000, 150);
        Hovercraft hovercraft = new Hovercraft(120, "Hovercraft Model", 350000, 50);
        Ship ship = new Ship(30, "Ship Model", 2000000, 5000);

        System.out.println("Car Promo Price: $" + car.checkPromo());
        System.out.println("Hovercraft Promo Price: $" + hovercraft.checkPromo());
        System.out.println("Ship Promo Price: $" + ship.checkPromo());

        car.enterLand();
        hovercraft.enterLand();
        hovercraft.enterSea();
        ship.enterSea();
    }
}