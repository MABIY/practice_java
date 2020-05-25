package chap4;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : lh
 * @since : 2020/5/25, Mon
 **/
public class StreamTest {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }
}
