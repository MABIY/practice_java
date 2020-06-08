package chap8;

import junit.framework.TestCase;
import lambda_t.predicate.Filter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
 * @author : lh
 * @since : 2020/6/8, Mon
 **/
public class PointTest extends TestCase {

    @Test
    public void testMoveRightBy() throws Exception {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);
        assertEquals(15, p2.getX());
        assertEquals(5, p2.getY());
    }

    @Test
    public void testComparingTwoPoints() throws Exception {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);

        int result = Point.compareByXAndThenY.compare(p1, p2);
        assertEquals(-1, result);
    }

    @Test
    public void testMoveAllPointsRightBy() throws Exception {
        List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));

        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
        assertEquals(expectedPoints, newPoints);
    }

    @Test
    public void testFilter() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> even = Filter.filter(numbers, i -> i % 2 == 0);
        List<Integer> smallerThanThree = Filter.filter(numbers, i -> i < 3);
        assertEquals(Arrays.asList(2, 4), even);
        assertEquals(Arrays.asList(1, 2), smallerThanThree);
    }
}