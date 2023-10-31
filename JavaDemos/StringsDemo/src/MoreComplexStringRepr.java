import java.util.Arrays;

public class MoreComplexStringRepr {
    public static void main(String[] args) {
        // create 2 strings with reference variables $s1$ and $s2$
        String s1 = new String("hi");
        String s2 = new String("hi");

        if (s1 == s2)
            System.out.println("Test 1: equal!");
        else
            System.out.println("Test 1: not equal!");

        // $s1$ and $s2$ do NOT refer to the same object!

        if (s1.equals(s2))
            System.out.println("Test 2: equal!");
        if (s2.equals(s1))
            System.out.println("Test 3: equal!");

        // Alias -> $s2$ gets the address of $s1$ object
        s2 = s1;
        if (s1 == s2)
            System.out.println("Test 4: equal!");
        // yes, an alias means the same object
        if (s1.equals(s2))
            System.out.println("Test 5: equal!");

        if (s1.equals("h"+"i"))
            System.out.println("Test 6: equal!");

        if ("hi" == "hi")
            System.out.println("Test 7: equal!");
        // The following works, too:
        if ("hi".equals("hi"))
            System.out.println("Test 8: equal!");

        String x = "hi";
        String y = "hi";

        if (x == y)
            System.out.println("Test 9: equal!");
        if (x.equals(y))
            System.out.println("Test 10: equal!");

        System.out.println("Test 11: " + (s1==x));
        System.out.println("Test 12: " + s1.equals(x));
        System.out.println("Test 13: " + s1.isEmpty());
        s1 +=":java:my friend";
        System.out.println("Test 14: " + Arrays.toString(s1.split(":")));
        System.out.println("Test 15: " + s1.contains(":#"));
        System.out.println("Test 16: " + s1.substring(2));
        System.out.println("Test 17: " + s1.substring(3,6));
        System.out.println("Test 18: " + Arrays.toString(s2.getBytes()));
        System.out.println("Test 19: " + y.replace("h", "#"));
        int a = Integer.parseInt("55", 10);
        System.out.println("Test 20: " + String.valueOf(a));
        System.out.println("" + a);
    }

}