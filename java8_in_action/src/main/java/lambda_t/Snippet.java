package lambda_t;

import java.io.File;
import java.util.Arrays;

/**
 * @author : lh
 * @since : 2020/5/21, Thu
 **/
public class Snippet {
    public static void main(String[] args) {
//        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.isHidden();
//            }
//        });

        File[] hiddenFiles = new File(".").listFiles(new Snippet()::iHidden);
        System.out.println(Arrays.toString(hiddenFiles));
    }

    public  boolean iHidden(File fileName) {
        return true;
    }
}
