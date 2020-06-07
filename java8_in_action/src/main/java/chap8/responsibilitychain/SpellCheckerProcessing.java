package chap8.responsibilitychain;

/**
 * @author lh
 */
public class SpellCheckerProcessing extends ProcessingObject<String>{
    @Override
    protected String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
