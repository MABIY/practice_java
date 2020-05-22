/**
 * @author : lh
 * @since : 2020/5/21, Thu
 **/
public class AppleFancyFormatter implements AppleForMatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }

}
