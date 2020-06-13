package chap9.diamond;

/**
 * @author lh
 */
public class D implements B, C {
    @Override
    public void hello() {
        System.out.println("hello from D");
    }

    public static void main(String[] args) {
        new D().hello();
    }
}
