package lambda_t;

import java.util.function.Predicate;

/**
 * @author : lh
 * @since : 2020/5/25, Mon
 **/
public class AppleNegateAndOrTest {
    public static void main(String[] args) {

        Predicate<Apple> redApply = (Apple a) -> {
            return true;};
        Predicate<Apple> notRedApple = redApply.negate();
        Predicate<Apple> redAndHeavyApply = redApply.and(a -> a.getWeight() > 140);
        Predicate<Apple> redAndHeavyAppleOrGreen = redApply.and(a -> a.getWeight() > 150)
                .or(a -> "green".equals(a.getColor()));
    }
}
