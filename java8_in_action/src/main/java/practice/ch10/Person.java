package practice.ch10;

import java.util.Optional;

/**
 * @author lh
 */
public class Person {
    private Optional<Car> car = Optional.empty();

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    public static void main(String[] args) {
        Optional<Car> optCar = Optional.empty();
        optCar = Optional.of(null);
        optCar = Optional.ofNullable(null);
    }
}
