package chap9;

/**
 * @author : lh
 * @since : 2020/6/13, Sat
 **/
public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
