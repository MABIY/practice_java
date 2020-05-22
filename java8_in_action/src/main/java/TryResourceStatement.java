import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author : lh
 * @since : 2020/5/22, Fri
 **/
class TestOfAutoClose implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new RuntimeException("auto close exception");
    }
}
class TestOfAutoClose1 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new RuntimeException("auto close exception1");
    }
}
public class TryResourceStatement {
    public static void main(String[] args) throws Exception {
        try (TestOfAutoClose t = new TestOfAutoClose(); TestOfAutoClose1 f = new TestOfAutoClose1()) {
            throw new RuntimeException("caller exception");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch" + e.getMessage());
        } finally {
            System.out.println("finally");
        }
    } }
