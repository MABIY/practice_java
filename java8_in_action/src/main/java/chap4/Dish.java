package chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dish {
    public static final List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames = menu.stream().filter(d -> {
            System.out.println(Thread.currentThread() + " test");
            return d.getCalories() > 300;
        }).filter(d -> {
            System.out.println(Thread.currentThread() + "filter2");
            return true;
        })
                .map(Dish::getName)
                .limit(20)
                .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public CaloricLevel getCaloricLevel() {
        if (getCalories() <= 400) {
            return Dish.CaloricLevel.DIET;
        } else if (getCalories() <= 700) {
            return Dish.CaloricLevel.NORMAL;
        } else {
            return Dish.CaloricLevel.FAT;
        }
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public enum Type {MEAT, FISH, OTHER}
}