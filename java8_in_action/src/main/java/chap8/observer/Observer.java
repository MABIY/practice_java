package chap8.observer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 */
public interface Observer {
    void notify(String tweet);
}

class NYTimes implements Observer{
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}

class Guardian implements Observer{
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}

class LeMonde implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }

}

interface Subject{
    void registerObserver(Observer o);

    void notifyObservers(String tweet);

    public static void main(String[] args) {
        Feed f = new Feed();
        // f.registerObserver(new NYTimes());
        // f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favorite book is Java 8 in Action!");

        f.registerObserver((String tweet)->{
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        f.registerObserver((String tweet)->{
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London..." + tweet);
            }
        });
    }
}

class Feed implements Subject{
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
