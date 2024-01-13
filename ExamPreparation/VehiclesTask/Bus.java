package VehiclesTask;

import java.util.Objects;

public class Bus extends Vehicle {
    private int capacity;
    public Bus(String brand, String model, int year, int capacity) {
        super(brand, model, year);
        setCapacity(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BUS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return capacity == bus.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "capacity=" + capacity +
                '}' + super.toString();
    }
}
