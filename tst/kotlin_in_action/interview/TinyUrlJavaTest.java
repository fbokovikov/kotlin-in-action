package kotlin_in_action.interview;


import kotlin_in_action.interview.tiny.url.TinyUrlJava;
import org.junit.jupiter.api.Test;

public class TinyUrlJavaTest {

    @Test
    public void tinyUrlTest() {
        String url = "https://www.google.com/search?q=english+alphabet&rlz=1C5CHFA_enUS877US877&oq=english+alphabet&aqs=chrome..69i57.4188j0j7&sourceid=chrome&ie=UTF-8";

        TinyUrlJava tinyUrlJava = new TinyUrlJava();
        String tinyUrl = tinyUrlJava.createTinyUrl(url);
        System.out.println(tinyUrl);
        String originalUrl = tinyUrlJava.getOriginalUrl(tinyUrl);
        System.out.println(originalUrl);
    }
}
