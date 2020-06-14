package chap11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author lh
 */
public class Shop {
    Random random = new Random();
    public double getPrice(String product) {
        // todo
        return 0.0;
    }

    private double calcalatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = calcalatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }
}
