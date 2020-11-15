package practice.ch10;

import com.alibaba.fastjson.JSON;

import java.util.Objects;
import java.util.Optional;

/**
 * @author lh
 */
public class Insurance {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);

        Person person = new Person();
        Car car = new Car();
        car.setInsurance(Optional.of(new Insurance()));
        person.setCar(Optional.of(car));

        Optional<Person> optPerson = Optional.of(person);
        String name1 = optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(insurance1 -> Objects.requireNonNull(insurance1.getName())).orElse("Unkown");


    }


}
