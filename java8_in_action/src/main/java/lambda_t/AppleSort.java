package lambda_t;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : lh
 * @since : 2020/5/25, Mon
 **/

public class AppleSort {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.sort(new AppleComparator());
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed()
                .thenComparing(Apple::getColor));
    }
}


