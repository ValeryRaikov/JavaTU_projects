// Apart from the classic string methods Java StringBuilder contains its own methods.
// In this snippet I test some of them...

import java.lang.StringBuilder;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Like");
        sb.append(" and Subscribe!");
        System.out.println(sb);

        sb.delete(0, 5);
        System.out.println(sb);

        sb.insert(sb.length(), " Please:)");
        System.out.println(sb);

        sb = new StringBuilder("Like and Subscribe!");
        sb.replace(5, sb.length(), "and Share!");
        System.out.println(sb);

        //System.out.println(sb.repeat(sb, 2));

        System.out.println("Reversed string is " + sb.reverse());

        // And many more methods already tested in the Strings file
    }
}