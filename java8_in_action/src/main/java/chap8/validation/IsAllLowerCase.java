package chap8.validation;

/**
 * @author lh
 */
public class IsAllLowerCase implements ValidationStrategy<String> {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }

}
