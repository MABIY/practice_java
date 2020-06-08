package chap8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : lh
 * @since : 2020/6/8, Mon
 **/
public class Point {
    public final static Comparator<Point> compareByXAndThenY =
            Comparator.comparing(Point::getX).thenComparing(Point::getY);
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }

    public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
        return points.parallelStream()
                .map(p -> new Point(p.getX() + x, p.getY()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point = (Point) obj;
            if (x == point.getX()
                    && y == point.getY()) {
                return true;
            }
        }
        return false;
    }
}

