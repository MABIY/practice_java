package lambda_t;

/**
 * @author : lh
 * @since : 2020/5/22, Fri
 **/
public class RunningTest {
    public static Runnable r1 = () -> System.out.println("Hello World!");
    public static Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello World 2");
        }
    };

    public static void main(String[] args) {
        process(r1);
        process(r2);
        process(() -> { System.out.println("Hello World 3"); });
    }

    public static void process(Runnable r) {
        r.run();
    }
}
