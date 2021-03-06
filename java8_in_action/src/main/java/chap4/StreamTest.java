package chap4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author : lh
 * @since : 2020/5/25, Mon
 */
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
    // <editor-fold desc="筛选">
    List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    integers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    // </editor-fold>
    // <editor-fold desc="截短流">
    List<Dish> dishes =
            Dish.menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());
    // </editor-fold>
    // <editor-fold desc="跳过元素">
    List<Dish> dishes_skip =
            Dish.menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
    // </editor-fold>

    List<Boolean> dishNames = Dish.menu.stream().map(Dish::isVegetarian).collect(toList());

    List<String> words = Arrays.asList("Java 8", "Lambda", "In", "Action");
    List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
    List<Integer> dishNameLengths =
            Dish.menu.stream().map(Dish::getName).map(String::length).collect(toList());

    words = Arrays.asList("Hello", "Word");
    words.stream().map(word -> word.split("")).distinct().collect(toList());
    words.stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(toList());

    List<String> uniqueCharacters =
            words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(toList());

    List<Integer> number1 = Arrays.asList(1, 2, 3);
    List<Integer> number2 = Arrays.asList(3, 4);
    List<int[]> paris =
            number1.stream()
                    .flatMap(i -> number2.stream().map(j -> new int[]{i, j}))
                    .collect(toList());

    List<int[]> pairs_2 =
            number1.stream()
                    .flatMap(i -> number2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j}))
                    .collect(toList());
    if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
      System.out.println("The menu is (somewhat) vegetarian friendly!!");
    }

    boolean isHealthy = Dish.menu.stream().allMatch(d -> d.getCalories() < 1000);

    isHealthy = Dish.menu.stream().noneMatch(d -> d.getCalories() >= 1000);

    Optional<Dish> dish = Dish.menu.stream().filter(Dish::isVegetarian).findAny();

    Dish.menu.stream()
            .filter(Dish::isVegetarian)
            .findAny()
            .ifPresent(d -> System.out.println(d.getName()));

    List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
    Optional<Integer> firstSquareDivisibleByThree =
            someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst();
    //        reduce
    int[] numbers = {1, 2, 3};
    int sum = Arrays.stream(numbers).reduce(0, Integer::sum);
    numbers = new int[]{10, 20};
    OptionalInt sum_optional = Arrays.stream(numbers).reduce((a, b) -> a + b);
    System.out.println(sum_optional.getAsInt());

    OptionalInt min = Arrays.stream(numbers).reduce((x, y) -> Math.min(x, y));

    List<Integer> integers1 = Arrays.asList(1, 2);
    Optional<Integer> optionalInteger = integers1.stream().reduce(Integer::max);

    int count = Dish.menu.stream().map(d -> 1).reduce(0, Integer::sum);
    long count_stream = Dish.menu.stream().count();

    int calories = Dish.menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);

    calories = Dish.menu.stream().mapToInt(Dish::getCalories).sum();

    IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories);

    Stream<Integer> stream = intStream.boxed();

    OptionalInt maxCalories = Dish.menu.stream().mapToInt(Dish::getCalories).max();

    int max = maxCalories.orElse(1);

    IntStream evenNumBers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
    System.out.println(evenNumBers.count());

    evenNumBers = IntStream.range(2, 100).filter(n -> n % 2 == 0);
    System.out.println(evenNumBers.count());

    System.out.println((int) 1.11);

    int a = 10;
    IntStream.rangeClosed(1, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
            .boxed()
            .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});

    IntStream.rangeClosed(1, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
            .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});
    Stream<int[]> pythagoreanTriples =
            IntStream.rangeClosed(1, 100)
                    .boxed()
                    .flatMap(
                            f ->
                                    IntStream.rangeClosed(f, 100)
                                            .filter(b -> Math.sqrt(f * f + b * b) % 1 == 0)
                                            .mapToObj(b -> new int[]{f, b, (int) Math.sqrt(f * f + b * b)}));
    pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    Stream<double[]> pythagoreanTriples_double =
            IntStream.rangeClosed(1, 100)
                    .boxed()
                    .flatMap(
                            g ->
                                    IntStream.rangeClosed(g, 100)
                                            .mapToObj(b -> new double[]{g, b, Math.sqrt(g * g + b * b)})
                                            .filter(t -> t[2] % 1 == 0));

    Stream<String> stream1 = Stream.of("Java 8", "Lambdas ", "In ", "Action");
    stream1.map(String::toUpperCase).forEach(System.out::println);
    Stream<String> emptyStream = Stream.empty();

    int[] numbers1 = {2, 3, 4, 5, 6, 7, 11, 13};
    int sum1 = Arrays.stream(numbers).sum();

    long uniqueWords = 0;
    try (Stream<String> lines = Files.lines(Paths.get("pom.xml"), Charset.defaultCharset())) {
      uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(uniqueWords);

    Stream.generate(Math::random).limit(5).forEach(System.out::println);
    IntStream ones = IntStream.generate(() -> 1);

    IntStream twos =
            IntStream.generate(
                    new IntSupplier() {
                      @Override
                      public int getAsInt() {
                        return 2;
                      }
                    });

    IntSupplier fib =
            new IntSupplier() {
              private int previous = 0;
              private int current = 1;

              @Override
              public int getAsInt() {
                int oldPrevious = previous;
                int nextValue = previous + current;
                previous = current;
                current = nextValue;
                return oldPrevious;
              }
            };

    Map<Dish.Type, Map<String, List<Dish>>> dishesByTypeCaloricLevel =
            Dish.menu.stream()
                    .collect(
                            groupingBy(
                                    Dish::getType,
                                    groupingBy(
                                            dish1 -> {
                                              if (dish1.getCalories() < 400) {
                                                return "DIEF";
                                              } else if (dish1.getCalories() <= 700) {
                                                return "NORMAL";
                                              } else {
                                                return "FAT";
                                              }
                                            })));
    System.out.println(dishesByTypeCaloricLevel);
    Map<Dish.Type, Long> typesCount =
            Dish.menu.stream().collect(groupingBy(Dish::getType, counting()));
    System.out.println(typesCount);

    Map<Dish.Type, Optional<Dish>> mostCaloricByType =
            Dish.menu.stream()
                    .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
    System.out.println(mostCaloricByType);
    Map<Dish.Type, Dish> mostCaloricByTypeGet =
            Dish.menu.stream()
                    .collect(
                            groupingBy(
                                    Dish::getType,
                                    collectingAndThen(
                                            maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

    Map<Dish.Type, Integer> totalCaloriesByType =
            Dish.menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

    Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType =
            Dish.menu.stream()
                    .collect(
                            groupingBy(
                                    Dish::getType,
                                    mapping(
                                            dish_1 -> {
                                              if (dish_1.getCalories() <= 400) {
                                                return Dish.CaloricLevel.DIET;
                                              } else if (dish_1.getCalories() <= 700) {
                                                return Dish.CaloricLevel.NORMAL;
                                              } else {
                                                return Dish.CaloricLevel.FAT;
                                              }
                                            },
                                            toSet())));

    caloricLevelsByType =
            Dish.menu.stream()
                    .collect(
                            groupingBy(
                                    Dish::getType,
                                    mapping(
                                            dish_2 -> {
                                              if (dish_2.getCalories() <= 400) {
                                                return Dish.CaloricLevel.DIET;
                                              } else if (dish_2.getCalories() <= 700) {
                                                return Dish.CaloricLevel.NORMAL;
                                              } else {
                                                return Dish.CaloricLevel.FAT;
                                              }
                                            },
                                            toCollection(HashSet::new))));
    System.out.println(caloricLevelsByType);

    Map<Boolean, List<Dish>> partitionedMenu =
            Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
    System.out.println(partitionedMenu);
    List<Dish> vegetarianDishes = Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());

    Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
            Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    System.out.println(vegetarianDishesByType);

    Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
            Dish.menu.stream()
                    .collect(
                            partitioningBy(
                                    Dish::isVegetarian,
                                    collectingAndThen(
                                            maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
    System.out.println(mostCaloricPartitionedByVegetarian);
    Collection<Dish> dishesf = Dish.menu.stream().collect(Collectors.toCollection(HashSet::new));

  }

//  public boolean isPrime(int candidate) {
//    return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
//  }

  public static boolean isPrime(int candidate) {
    int candidateRoot = (int) Math.sqrt(candidate);
    return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
  }

  public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
    return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(candidate -> isPrime(candidate)));
  }

  public BiConsumer<List, ?> accumulator() {
    return List::add;
  }
}
