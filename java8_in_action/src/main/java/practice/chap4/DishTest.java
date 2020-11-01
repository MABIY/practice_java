package practice.chap4;

import java.util.Optional;

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
    }
}
