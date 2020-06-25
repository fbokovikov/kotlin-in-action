package kotlin_in_action.interview.tiny.url;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TinyUrlJava {

    private static final char[] CHARS = "abcdefghijklmnopqrstvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static final int CHARS_NUMBER = CHARS.length;
    private static final int ALPHABET_SIZE = 26;

    private Map<Integer, String> idToUrlMap = new HashMap<>();
    private AtomicInteger tinyUrlCounter = new AtomicInteger(0);

    public String createTinyUrl(String originalUrl) {
        int curId = tinyUrlCounter.incrementAndGet();
        idToUrlMap.put(curId, originalUrl);
        StringBuilder tinyUrl = new StringBuilder();
        while (curId > 0) {
            char curChar = CHARS[curId % CHARS_NUMBER];
            tinyUrl.append(curChar);
            curId /= CHARS_NUMBER;
        }
        return tinyUrl.toString();
    }

    public String getOriginalUrl(String tinyUrl) {
        int id = 0;
        for (int i = 0; i < tinyUrl.length(); i++) {
            char curChar = tinyUrl.charAt(tinyUrl.length() - i - 1);
            if (curChar >= 'a' && curChar <= 'z') {
                id += (curChar - 'a') * Math.pow(CHARS_NUMBER, i);
            } else if (curChar >= 'A' && curChar <= 'Z') {
                id += ((curChar - 'A' + ALPHABET_SIZE) * Math.pow(CHARS_NUMBER, i));
            } else {
                id += (curChar - '0' + ALPHABET_SIZE * 2) * Math.pow(CHARS_NUMBER, i);
            }
        }
        return Optional.ofNullable(idToUrlMap.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Url not found: " + tinyUrl));
    }
}
