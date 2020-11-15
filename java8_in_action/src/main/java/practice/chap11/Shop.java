package practice.chap11;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author lh
 */
public class Shop {
    public String name;
    public Shop(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
    public void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    Random random = new Random();
    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) * product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product) {
        // CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        // new Thread(() -> {
        //     double price = calculatePrice(product);
        //     futurePrice.complete(price);
        // }).start();
        // return futurePrice;

        // CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        // new Thread(() -> {
        //     try {
        //         double price = calculatePrice(product);
        //         futurePrice.complete(price);
        //     } catch (Exception exception) {
        //         futurePrice.completeExceptionally(exception);
        //     }
        // }).start();
        // return futurePrice;
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

}
