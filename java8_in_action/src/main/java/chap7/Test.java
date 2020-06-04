package chap7;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : lh
 * @since : 2020/6/3, Wed
 **/
public class Test {

    public int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            // todo
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

    static final String SENTENCE = " Nel mezzo del cammin di nostra vita " +
            "mi ritrovai in una selva oscura" +
            " che la dritta via era smarrita ";

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("Found " + test.countWordsIteratively(SENTENCE) + " words");
    }

    Stream<Character> stream = IntStream.range(0, SENTENCE.length())
            .mapToObj(SENTENCE::charAt);

}
