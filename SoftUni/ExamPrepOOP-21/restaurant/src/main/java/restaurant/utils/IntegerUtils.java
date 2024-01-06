package restaurant.utils;

public class IntegerUtils {
    public static void LessEqualZeroCheck(int field, String message) {
        if (field <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
