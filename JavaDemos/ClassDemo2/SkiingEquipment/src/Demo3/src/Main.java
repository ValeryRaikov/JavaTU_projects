import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SwimmingPool> swimmingPools = new ArrayList<>();

        swimmingPools.add(new SwimmingPool("Atletik", "Dianabad st. 22", 99.99, "9.00 - 22.00"));
        swimmingPools.add(new SwimmingPool("TU Sofia pool", "G.M Dimitrov TU-uni", 79.99, "9-30 - 18.30"));
        swimmingPools.add(new SwimmingPool("Slavia", "zh. k. Ovcha Kupel 5", 119.99, "8.00 - 20.00"));

        SwimmingPool.printOlympicPool();

        for (SwimmingPool pool: swimmingPools) {
            System.out.println(pool.toString());
        }
    }
}
