package chap9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : lh
 * @since : 2020/6/8, Mon
 **/
public class ShortTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
        numbers.sort(Comparator.naturalOrder());
    }
}
