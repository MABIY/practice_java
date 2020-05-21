import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author : lh
 * @since : 2020/5/21, Thu
 **/
public class Test {
    public static void main(String[] args) {
        filter(null, () -> {return "fdsa";});
    }

    public static List<String> filter(List<String> list, FuncationTest funcationTest){
        return null;
    }
}
interface FuncationTest{
    String apply();
}
