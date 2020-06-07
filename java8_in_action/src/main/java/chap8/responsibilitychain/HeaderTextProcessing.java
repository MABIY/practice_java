package chap8.responsibilitychain;

/**
 * @author lh
 */
public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String text) {
        return "From Raoul, Mario And Alan: " + text;
    }
}
