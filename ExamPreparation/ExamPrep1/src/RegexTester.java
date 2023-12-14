import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
    public static List<Boolean> test(Regex regex, String[] strings) {
        Pattern pattern = Pattern.compile(regex.getPattern());

        List<Boolean> matches = new ArrayList<>();

        for (String temp: strings) {
            Matcher matcher = pattern.matcher(temp);

            if (matcher.matches())
                matches.add(true);
            else
                matches.add(false);
        }

        return matches;
    }
}
