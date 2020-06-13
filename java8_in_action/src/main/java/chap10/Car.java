package chap10;

import java.util.Optional;

/**
 * @author lh
 */
public class Car {
    private Optional<Insurance> insurance = Optional.ofNullable(null);

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
