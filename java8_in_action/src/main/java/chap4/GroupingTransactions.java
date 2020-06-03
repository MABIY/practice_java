package chap4;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static chap4.Dish.menu;
import static java.util.stream.Collectors.*;

public class GroupingTransactions {

    public static List<Transaction> transactions = Arrays.asList(new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0));

    public static void main(String... args) {
        Map<Currency, List<Transaction>> transactionByCurrencies =
                transactions.stream().collect(groupingBy(Transaction::getCurrency));
        Comparator<Dish> dishCaloriesComparator = Comparator.comparing(Dish::getName);
        Optional<Dish> maxDish = menu.stream().collect(maxBy(dishCaloriesComparator));
        Optional<Dish> minDish = menu.stream().collect(minBy(dishCaloriesComparator));
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));

        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu);
        shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);

        int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));

        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();

        //todo meaning
        List<Integer> numbers = stream.parallel().reduce(
                new ArrayList<>(),
                (List<Integer> l, Integer e) -> {
                    System.out.println(Thread.currentThread() + ": " + l + " add " + e);
                    l.add(e);
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) -> {
                    List<Integer> temp = l1;
                    l1.addAll(l2);
                    System.out.println(Thread.currentThread() + ": " + "l1 " + temp + " add " + "l2 " + l2 + " result" + l1);
                    return l1;

                }
        );
        System.out.println(numbers);

        totalCalories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        List test = new ArrayList<>();
        String testResult = (String) test.stream().collect(reducing("", Dish::getName, (s1, s2) -> s1 + s2));
        Map<Dish.Type, List<Dish>> dishesBypes = menu.stream().collect(groupingBy(Dish::getType));
    }

    public static <T> Collector<T,?,Long> counting() {
        return reducing(0L, e -> 1L, Long::sum);
    }


    public static class Transaction {
        private final Currency currency;
        private final double value;

        public Transaction(Currency currency, double value) {
            this.currency = currency;
            this.value = value;
        }

        public Currency getCurrency() {
            return currency;
        }

        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return currency + " " + value;
        }
    }

    public enum Currency {
        EUR, USD, JPY, GBP, CHF
    }
}
