package lambda_t;

import java.util.Comparator;

/**
 * @author : lh
 * @since : 2020/5/25, Mon
 **/
public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}
