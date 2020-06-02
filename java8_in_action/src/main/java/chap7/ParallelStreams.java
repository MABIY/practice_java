package chap7;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author : lh
 * @since : 2020/6/2, Tue
 **/
public class ParallelStreams {
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }

        return fastest;
    }

    public static void main(String[] args) {
//        System.out.println("Sequential sum done in:" +
//                measureSumPerf(ParallelStreams::sequentialSum, 10_000_000) + " msecs");

//        System.out.println("iterativeSum sum done in:" +
//                measureSumPerf(ParallelStreams::iterativeSum, 10_000_000) + " msecs");

        System.out.println("parallelSum sum done in:" +
                measureSumPerf(ParallelStreams::parallelSum, 10_000_000) + " msecs");

    }


}
