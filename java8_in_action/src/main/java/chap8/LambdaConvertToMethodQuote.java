package chap8;

import chap4.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * @author : lh
 * @since : 2020/6/5, Fri
 **/
public class LambdaConvertToMethodQuote {

    Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel =
            Dish.menu.stream()
                    .collect(groupingBy(Dish::getCaloricLevel));

    {
        int totalCalories =
                Dish.menu.stream().map(Dish::getCalories)
                        .reduce(0, (c1, c2) -> c1 + c2);
    }

    {
        int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));
    }

    public static void main(String[] args) {
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : Dish.menu) {
            if (dish.getCalories() > 300) {
                dishNames.add(dish.getName());
            }
        }
        System.out.println("for each dishNames result: " + dishNames);
        // 替换成
        dishNames = Dish.menu.parallelStream()
                .filter(d -> {
                    return d.getCalories() > 300;
                })
                //.sorted(Comparator.comparingInt(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("stream dishNames result: " + dishNames);
    }

}
