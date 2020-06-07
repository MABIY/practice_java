package chap8.validation;

/**
 * @author lh
 */
@FunctionalInterface
public interface ValidationStrategy<T> {
    boolean execute(T s);
}
