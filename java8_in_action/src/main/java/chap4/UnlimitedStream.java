package chap4;

import java.util.stream.Stream;

/**
 * @author : lh
 * @since : 2020/5/29, Fri
 */
public class UnlimitedStream {
    public static void main(String[] args) {
//        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + "}"));
    }
}
