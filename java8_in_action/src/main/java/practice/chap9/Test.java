package practice.chap9;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author lh
 */

interface F{
    default String getNme() {
        return "F.name";
    }
}
class A {
    public String getNme() {
        return "A.name";
    }
}
class B extends A{

}

class C extends B{

}

class D extends C implements F{
    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.getNme());
    }
}
public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
        List<String> objectList = new ArrayList<>();
        objectList.add("a");
        objectList.add("A");
        objectList.add("c");
        System.out.println((int)'1');
        Predicate<String> stringPredicate = Predicate.isEqual("12");
        System.out.println(stringPredicate.test("33"));
        List<String> a = new ArrayList<>();
        for (Iterator<String> iterator = a.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            iterator.remove();
        }
    }
}
