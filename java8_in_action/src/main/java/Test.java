import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : lh
 * @since : 2020/5/21, Thu
 **/
public class Test {
//    public static void main(String[] args) {
//        filter(null, () -> {return "fdsa";});
//    }
//
    public static List<String> filter(List<String> list, FuncationTest funcationTest){
        return null;
    }

    public static void main(String[] args) {
        Supplier<Apple> c1 = Apple::new;
        c1.get();
        Supplier<Apple> c2 = () -> new Apple();
        Apple a1 = c1.get();
    }
}
interface FuncationTest{
    String apply();
}
