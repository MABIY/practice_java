package chap8;

import chap4.Dish;

import java.util.List;
import java.util.Map;

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
}
