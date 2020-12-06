package java8.lambdas.functinoal.programming.masses.chap2.c2_2;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * @author : lh
 * @since : 2020/12/6, Sun
 **/
public class Lambda {
    public static void main(String[] args) {
        {
            Runnable noArgument = () -> System.out.println("Hello World");

            ActionListener oneArgument = event -> System.out.println("button clicked");

            Runnable multiStatement = () -> {
                System.out.print("Hello");
                System.out.print(" World");
            };
        }

        {
            BinaryOperator<Long> add = (x, y) -> x + y;
            BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
        }
    }
}
