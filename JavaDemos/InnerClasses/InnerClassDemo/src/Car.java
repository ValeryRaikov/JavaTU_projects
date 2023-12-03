public class Car {
    private String brand;
    private String model;
    private double price;
    private Engine engine;

    public Car(String brand, String model, double price, String fuelType, int horsePower, int mileage) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.engine = new Engine(fuelType, horsePower, mileage);
    }

    public String getFuelType() {
        return engine.fuelType;
    }

    public void setFuelType(String fuelType) {
        engine.fuelType = fuelType;
    }

    public int getHorsePower() {
        return engine.horsePower;
    }

    public void setHorsePower(int horsePower) {
        engine.horsePower = horsePower;
    }

    public int getMileage() {
        return engine.mileage;
    }

    public void setMileage(int mileage) {
        engine.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void honk() {
        System.out.printf("Car %s %s is honking at you.%n", this.getBrand(), this.getModel());
    }

    public void printCar() {
        System.out.printf("Car %s %s costs %.2f leva.%n", this.getBrand(), this.getModel(), this.getPrice());
    }

    public class Engine {
        private String fuelType;
        private int horsePower;
        private int mileage;

        public Engine(String fuelType, int horsePower, int mileage) {
            this.fuelType = fuelType;
            this.horsePower = horsePower;
            this.mileage = mileage;
        }

        public String getFuelType() {
            return fuelType;
        }

        public void setFuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public void startEngine() {
            System.out.printf("Engine of car %s %s is a %s engine and is currently running on.%n",
                    Car.this.getBrand(), Car.this.getModel(), this.getFuelType());
        }

        public void printEngine() {
            System.out.printf("%s engine has %d hp and is at %d km.%n",
                    this.getFuelType(), this.getHorsePower(), this.getMileage());
        }
    }
}
