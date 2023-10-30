import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String test = "This is a test string!";

        String substring = test.substring(0, 4);
        //String substring = test.subSequence(0, 4);
        System.out.println(substring);
        System.out.println(substring.repeat(3));

        String substring2 = test.substring(5);
        System.out.println(substring2);

        System.out.println(substring.equals("This"));
        //substring.equalsIgnoreCase("this");
        System.out.println("Length is " + substring2.length());

        char letter = test.charAt(6);
        char letter2 = test.charAt(test.length() - 1);
        int index = test.indexOf("t");
        //int index2 = test.lastIndexOf("t");
        boolean result = test.isEmpty();
        boolean result2 = substring.isBlank();

        System.out.println(test.toUpperCase());
        System.out.println(test.toLowerCase());

        char[] arr = test.toCharArray();
        System.out.println(Arrays.toString(arr));

        String test2 = "   Hello, Bros  ";
        System.out.println(test2.trim());

        String res = test2.replace("o", "0");
        //test2.replaceAll("l", "!");
        //test2.replaceFirst("l", "!");
        System.out.println(test2.getBytes());

        System.out.println(test2.trim().compareTo("Hello, Jimmy"));

        String newtest = test2.concat(":)");
        System.out.println(test2.contains("o"));

        boolean start = test.startsWith("H");
        boolean end = test.endsWith("!");

        String wordSplit = "Split-test-in-java";
        String[] arrOfStr = wordSplit.split("-");
        for (String a: arrOfStr) {
            System.out.println(a);
        }
    }
}
