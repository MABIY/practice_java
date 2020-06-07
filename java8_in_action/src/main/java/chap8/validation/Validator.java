package chap8.validation;

/**
 * @author lh
 */
public class Validator<T> {
    private final ValidationStrategy<T> strategy;

    public Validator(ValidationStrategy<T> v) {
        this.strategy = v;
    }

    public boolean validate(T s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        numericValidator = new Validator<String>((String s)->s.matches("[a-z]+"));
        b1 = numericValidator.validate("aaaa");

        lowerCaseValidator = new Validator<String>((String s) ->
                s.matches("\\d+"));
        b2 = lowerCaseValidator.validate("bbbb");
    }
}
