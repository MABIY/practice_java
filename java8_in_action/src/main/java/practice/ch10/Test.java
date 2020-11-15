package practice.ch10;

import com.alibaba.fastjson.JSON;

import java.util.Optional;

/**
 * @author lh
 */
public class Test {
    private Optional<Car> car = Optional.of(new Car());

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    public static void main(String[] args) {

        Optional a = Optional.ofNullable(new Car());
        Test test = new Test();
        JSON.parseObject(JSON.toJSONString(a), Optional.class);
    }
}
