package chap9.diamond;

/**
 * @author lh
 */
public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
