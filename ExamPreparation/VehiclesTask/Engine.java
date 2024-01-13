package VehiclesTask;

import java.util.Objects;

public class Engine {
    private EngineType engineType;
    private int horsepower;
    double fuelConsumption;

    public Engine(EngineType engineType, int horsepower, double fuelConsumption) {
        setEngineType(engineType);
        setHorsepower(horsepower);
        setFuelConsumption(fuelConsumption);
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return horsepower == engine.horsepower && Double.compare(fuelConsumption, engine.fuelConsumption) == 0 && engineType == engine.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineType, horsepower, fuelConsumption);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineType=" + engineType +
                ", horsepower=" + horsepower +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
