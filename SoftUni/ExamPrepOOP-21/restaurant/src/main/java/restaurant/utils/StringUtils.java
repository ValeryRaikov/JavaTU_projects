package restaurant.utils;

public class StringUtils {
    public static void nullOrEmptyCheck(String field, String message) {
        if (field == null || field.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
