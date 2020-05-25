package lambda_t.funcation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author : lh
 * @since : 2020/5/24, Sun
 **/
public class funcation {
    public static void main(String[] args) {
        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), String::length);
    }
    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
