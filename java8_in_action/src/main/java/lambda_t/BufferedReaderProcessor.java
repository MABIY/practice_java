package lambda_t;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;

/**
 * @author : lh
 * @since : 2020/5/22, Fri
 **/
@FunctionalInterface
public interface BufferedReaderProcessor {
     String process(BufferedReader b) throws IOException;
}
