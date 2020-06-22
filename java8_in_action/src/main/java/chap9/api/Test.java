package chap9.api;

import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author : lh
 * @since : 2020/6/17, Wed
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.testParallelStreamWithException();
    }

    public void testParallelStreamWithException() throws InterruptedException {
        AtomicInteger overallCount = new AtomicInteger(0);
        AtomicInteger afterExceptionCount = new AtomicInteger(0);
        AtomicBoolean throwException = new AtomicBoolean(true);

        try {
            IntStream.range(0, 1000)
                    .parallel()
                    .forEach(i -> {
                        overallCount.incrementAndGet();
                        afterExceptionCount.incrementAndGet();
                        try {
                            System.out.println(i + " Sleeping...");
                            Thread.sleep(1000);
                            System.out.println(i + " After Sleeping.");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // Throw only on one of the threads and not on main thread.
                        if (Thread.currentThread().getName().equals("main") && throwException.compareAndSet(true, false)) {
                            System.out.println("Throwing exception - " + i);
                            throw new RuntimeException("One of the tasks threw an exception. Index: " + i);
                        }
                    });
            Assert.fail("Should not get here.");
        } catch (Exception e) {
            System.out.println("Cought Exception. Resetting the afterExceptionCount to zero - 0.");
            afterExceptionCount.set(0);
        }

        TimeUnit.SECONDS.sleep(60);
        System.out.println("Overall count: " + overallCount.get());
        System.out.println("After exception count: " + afterExceptionCount.get());

    }
    

}
