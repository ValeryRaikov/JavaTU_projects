package RegexExam;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
    public static List<Boolean> test(Regex regex, String[] strings) {
        Pattern pattern = Pattern.compile(regex.getPattern());

        List<Boolean> stringMatches = new ArrayList<>();

        for (String string: strings) {
            Matcher matcher = pattern.matcher(string);

            if (matcher.matches())
                stringMatches.add(true);
            else
                stringMatches.add(false);
        }

        return stringMatches;
    }
}
