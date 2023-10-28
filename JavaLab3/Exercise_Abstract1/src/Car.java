public class Car extends Vehicle implements IsLandVehicle {
    private double enginePower;

    public Car(double maxSpeed, String model, double price, double enginePower) {
        super(maxSpeed, model, price);
        this.enginePower = enginePower;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public double checkPromo() {
        return getPrice() * 0.8;
    }

    @Override
    public void enterLand() {
        System.out.println("Car can travel on land.");
    }
}