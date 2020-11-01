package practice.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dish {
    public static final List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Type.MEAT),
                    new Dish("beef", false, 700, Type.MEAT),
                    new Dish("chicken", false, 400, Type.MEAT),
                    new Dish("french fries", true, 530, Type.OTHER),
                    new Dish("rice", true, 350, Type.OTHER),
                    new Dish("season fruit", true, 120, Type.OTHER),
                    new Dish("pizza", true, 550, Type.OTHER),
                    new Dish("prawns", false, 400, Type.FISH),
                    new Dish("salmon", false, 450, Type.FISH));


    public void setName(String name) {
        this.name = name;
    }

    private String name;
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
            return CaloricLevel.DIET;
        } else if (getCalories() <= 700) {
            return CaloricLevel.NORMAL;
        } else {
            return CaloricLevel.FAT;
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