package chap7;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static chap7.Test.SENTENCE;

/**
 * @author : lh
 * @since : 2020/6/2, Tue
 **/
public class ParallelStreams {
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

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        "123".substring(0, 1);
//        System.out.println("Sequential sum done in:" +
//                measureSumPerf(ParallelStreams::sequentialSum, 10_000_000) + " msecs");

//        System.out.println("iterativeSum sum done in:" +
//                measureSumPerf(ParallelStreams::iterativeSum, 10_000_000) + " msecs");

//        System.out.println("parallelSum sum done in:" +
//                measureSumPerf(ParallelStreams::parallelSum, 10_000_000) + " msecs");

//        System.out.println("ranged sum done in:" +
//                measureSumPerf(ParallelStreams::rangedSum, 10_000_000) + " msecs");

//        System.out.println("parallelRangeSum sum done in:" +
//                measureSumPerf(ParallelStreams::parallelRangeSum, 10_000_000) + " msecs");


//        System.out.println("SideEffect sum done in: " +
//                measureSumPerf(ParallelStreams::sideEffectSum, 10_000_000L) + " msec");

//        System.out.println("SideEffect parallel sum done in: " +
//                measureSumPerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msec");


        System.out.println("SideEffect sum done in: " +
                measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000L) + " msec");
        IntStream.range(1, 10).reduce(0, (left, right) -> left + right);
    }

    private int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }



    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }


}

class Accumulator {
    public long total = 0;

    public void add(long value) {
        total += value;
    }
}
