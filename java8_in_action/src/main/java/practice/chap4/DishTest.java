package practice.chap4;

import org.omg.CORBA.INTERNAL;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lh
 */
public class DishTest {
    public static void main(String[] args) {
        {
            boolean isHealthy = Dish.menu.stream().anyMatch(dish -> dish.getCalories() < 1000);
            System.out.println("all menus calories less 10000: " + isHealthy);
        }
        {
            boolean isHealthy = Dish.menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
            System.out.println("none menus calories  big or equal 10000: " + isHealthy);
        }
        {
            Optional<Dish> dish = Dish.menu.stream().findAny();
        }
        {
            System.out.println("total value: " + Dish.menu.stream().reduce(0,
                    (integer, dish) -> {
                        System.out.println("accumulator->integer:" + integer + ", dish:" + dish);
                        return integer + dish.getCalories();
                    },
                    (integer, integer2) -> {
                        System.out.println("combiner->integer:" + integer + ", integer2:" + integer2);
                        return integer + integer2;

                    }));
        }
        {
            IntStream number = IntStream.range(0, 10);
            OptionalInt max = number.reduce(Integer::max);
        }

        {
            int count = Dish.menu.stream().map(dish -> 1).reduce(0, (a, b) -> a + b);
            System.out.println("count value: " + count);
        }

        {
            int calories = Dish.menu.stream()
                    .mapToInt(Dish::getCalories)
                    .sum();
        }

        {
            IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories);
            Stream<Integer> stream = intStream.boxed();
        }
    }
}
