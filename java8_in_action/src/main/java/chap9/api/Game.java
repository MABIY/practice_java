package chap9.api;

import java.util.Arrays;
import java.util.List;

/**
 * @author : lh
 * @since : 2020/6/8, Mon
 **/
public class Game {
    public static void main(String[] args) {
        List<Resizable> resizableShapes = Arrays.asList(
                new Square(), new Triangle(), new Ellipse()
        );
        Utils.paint(resizableShapes);
    }
}
