package chap8;

import junit.framework.TestCase;
import org.junit.Test;

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
}