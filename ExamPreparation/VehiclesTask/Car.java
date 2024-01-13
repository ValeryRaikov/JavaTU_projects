package VehiclesTask;

import java.util.List;
import java.util.Objects;

public class Car extends Vehicle {
    private Engine engineSpecs;

    public Car(String brand, String model, int year, Engine engineSpecs) {
        super(brand, model, year);
        setEngineSpecs(engineSpecs);
    }

    public Engine getEngineSpecs() {
        return engineSpecs;
    }

    public void setEngineSpecs(Engine engineSpecs) {
        this.engineSpecs = engineSpecs;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(engineSpecs, car.engineSpecs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineSpecs);
    }

    @Override
    public String toString() {
        return "Car{" +
                "engineSpecs=" + engineSpecs +
                '}' + super.toString();
    }
}
