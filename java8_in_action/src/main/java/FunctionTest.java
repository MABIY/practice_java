import org.omg.CORBA.INTERNAL;

import java.util.function.Function;

/**
 * @author : lh
 * @since : 2020/5/25, Mon
 **/
public class FunctionTest {
    Function<Integer, Integer> f = x -> x + 1;
    Function<Integer, Integer> g = x -> x * 2;
    Function<Integer, Integer> h = f.andThen(g);
    int result = h.apply(1);

    Function<Integer, Integer> f1 = x -> x + 1;
    Function<Integer, Integer> g1 = x -> x * 2;
    Function<Integer, Integer> h1 = f.compose(g);
    int result1 = h.apply(1);
    public static void main(String[] args) {

    }
}
