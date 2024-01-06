package restaurant.utils;

public class DoubleUtils {
    public static void LessEqualZeroCheck(double field, String message) {
        if (field <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
