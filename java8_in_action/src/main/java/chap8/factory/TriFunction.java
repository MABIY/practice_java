package chap8.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lh
 * @since : 2020/6/8, Mon
 **/
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);

    Map<String, TriFunction<Integer, Integer, String, ProductFactory.Product>> map = new HashMap<>();
}
