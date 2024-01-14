package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Test 1
//        System.out.println("Enter your phone number:");
//        String input = sc.nextLine();
//
//        Pattern pattern = Pattern.compile("\\+359\\d{9}");
//
//        Matcher matcher = pattern.matcher(input);
//
//        if (matcher.matches())
//            System.out.format("Phone number %s is valid!", input);
//        else
//            System.err.format("Phone number %s is invalid!", input);

//        Test 2
        System.out.println("Enter test emails (use ' ' delimiter)");
        String[] emails = sc.nextLine().split(" ");

        Pattern pattern = Pattern.compile("^[A-Za-z-_.]+@[a-z]{3,}.[a-z]{2,}$");

        for (String email: emails) {
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches())
                System.out.format("Email %s is valid!%n", email);
            else
                System.err.format("Email %s is invalid!%n", email);
        }
    }
}
