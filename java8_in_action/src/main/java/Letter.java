import java.util.function.Function;

/**
 * @author : lh
 * @since : 2020/5/25, Mon
 **/
public class Letter {
    public static String addHeader(String header) {
        return "From  Raoul, Mario and Alan: " + header;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    Function<String, String> addHeader = Letter::addHeader;
    Function<String, String> transformationPipeline = addHeader.andThen(Letter::addFooter);
}
