package chap7;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static chap7.Test.SENTENCE;

/**
 * @author : lh
 * @since : 2020/6/4, Thu
 **/
public class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter  accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this :
                    new WordCounter(counter, true);
        } else {
            if (lastSpace) {
                return new WordCounter(counter + 1, false);
            } else {
                return this;
            }
        }
    }

    @Override
    public String toString() {
        return "WordCounter{" +
                "counter=" + counter +
                ", lastSpace=" + lastSpace +
                '}';
    }

    public WordCounter combine(WordCounter wordCounter) {

        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine
        );
        return wordCounter.getCounter();
    }

    public static void main(String[] args) {
//        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
//                .mapToObj(SENTENCE::charAt);
//
//        System.out.println("Found " + countWords(stream) + " words");
//
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream1 = StreamSupport.stream(spliterator, true);
        System.out.println("Fond " + countWords(stream1) + " wordws");
    }
}
