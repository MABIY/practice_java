package char10;

import java.util.Optional;

/**
 * @author lh
 */
public class Person {
    private Optional<Car> car = Optional.ofNullable(null);

    public Optional<Car> getCar() {
        return car;
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        Person person = new Person();
        // System.out.println(getCarInsuranceName(Optional.ofNullable(null)));
        System.out.println(nullSafeFindCheapestInsurance(Optional.of(person), Optional.of(new Car())));
    }

    public static Optional<Insurance> nullSafeFindCheapestInsurance(
            Optional<Person> person, Optional<Car> car
    ) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public static  Insurance findCheapestInsurance(Person person, Car car) {
        return null;
    }
}
