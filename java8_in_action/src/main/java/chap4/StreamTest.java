package chap4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import static java.util.stream.Collectors.toList;

/**
 * @author : lh
 * @since : 2020/5/25, Mon
 **/
public class StreamTest {
    public static void main(String[] args) {
//        List<String> title = Arrays.asList("Java8", "In", "Action");
//        Stream<String> s = title.stream();
//        s.forEach(System.out::println);
//        s.forEach(System.out::println);
//
//        List<Dish> vegetarianDishes = Dish.menu
//                .stream().filter(Dish::isVegetarian)
//                .collect(Collectors.toList());
        //<editor-fold desc="筛选">
        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        integers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        //</editor-fold>
        //<editor-fold desc="截短流">
        List<Dish> dishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
        //</editor-fold>
        //<editor-fold desc="跳过元素">
        List<Dish> dishes_skip = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        //</editor-fold>

        List<Boolean> dishNames = Dish.menu.stream().map(Dish::isVegetarian)
                .collect(toList());


        List<String> words = Arrays.asList("Java 8", "Lambda", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        List<Integer> dishNameLengths = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        words = Arrays.asList("Hello", "Word");
        words.stream()
                .map(word -> word.split(""))
                .distinct().collect(toList());
        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(toList());


        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<int[]> paris = number1.stream()
                .flatMap(i -> number2
                        .stream()
                        .map(j -> new int[]{i, j}))
                .collect(toList());

        List<int[]> pairs_2 = number1.stream()
                .flatMap(i -> number2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                ).collect(toList());
        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = Dish.menu.stream().allMatch(d -> d.getCalories() < 1000);

        isHealthy = Dish.menu.stream().noneMatch(d -> d.getCalories() >= 1000);

        Optional<Dish> dish = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst();
//        reduce
        int[] numbers = {1, 2, 3};
        int sum = Arrays.stream(numbers).reduce(0, Integer::sum);
        numbers = new int[]{10, 20};
        OptionalInt sum_optional = Arrays.stream(numbers).reduce((a, b) -> a + b);
        System.out.println(sum_optional.getAsInt());
    }
}
