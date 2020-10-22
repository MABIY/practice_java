import java.util.HashMap;
import java.util.Map;

/**
 * @author : lh
 * @since : 2020/10/22, Thu
 * Typesafe heterogeneous container pattern -api
 **/
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance){
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }

}

class FavoritesClient {
    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class,"Java");
        f.putFavorite(Integer.class,0xcafebabe);
        f.putFavorite(Class.class,ThreadLocal.class);
        Object a = ThreadLocal.class;
    }
}