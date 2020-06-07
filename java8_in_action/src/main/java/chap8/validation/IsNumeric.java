package chap8.validation;

/**
 * @author lh
 */
public class IsNumeric  implements ValidationStrategy<String>{
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
