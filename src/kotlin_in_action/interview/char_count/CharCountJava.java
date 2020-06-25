package kotlin_in_action.interview.char_count;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCountJava {

    public static Map<Character, Integer> countChars(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), c -> 1, Integer::sum));
    }

    public static Map<Character, Integer> countCharsV2(String s) {
        Map<Character, Integer> result  = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            result.merge(s.charAt(i), 1, Integer::sum);
        }
        return result;
    }

    public static Map<Character, Long> countCharsV3(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
