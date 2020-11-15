package practice.ch10;


import java.util.Optional;

/**
 * @author lh
 */
public class Car {
    private Optional<Insurance> insurance = Optional.of(new Insurance());

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
