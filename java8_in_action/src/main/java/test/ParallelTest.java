package test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParallelTest {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Arrays.asList(111, 222, 333, 444);

        list.parallelStream().forEach(x -> {
            if (!Thread.currentThread().getName().equals("main")) {
                try {
                    System.out.println(Thread.currentThread() + "isSleeping");
                    TimeUnit.DAYS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });

        list.stream().forEach(x -> {
            if (!Thread.currentThread().getName().equals("main")) {
                while (true) {
                    System.out.println(Thread.currentThread() + "running");
                }
            }
        });
        TimeUnit.DAYS.sleep(1);
    }

}
