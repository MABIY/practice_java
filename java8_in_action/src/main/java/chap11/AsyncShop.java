package chap11;

import com.sun.org.apache.xpath.internal.functions.FuncTranslate;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author lh
 */
public class AsyncShop {
    private final String name;
    private final Random random;

    public AsyncShop(String name)
    {
        this.name = name;
        this.random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public Future<Double> getPrice(String product) {
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//            } catch (Exception ex) {
//                futurePrice.completeExceptionally(ex);
//            }
//        }).start();
//        return futurePrice;
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    private double calculatePrice(String product) {
        delay();
        if (true) {
            throw new RuntimeException("product not avaliable");
        }
        return 1.1;
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        AsyncShop asyncShop = new AsyncShop("BestShop");
        Future<Double> futurePrice = asyncShop.getPrice("myPhone");
        try {
            System.out.println("Price is " + futurePrice.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
