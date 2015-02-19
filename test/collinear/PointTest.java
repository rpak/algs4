import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointTest {

    /**
     * 4 |  |p1|  |  |p2|
     * 3 |  |  |  |  |  |
     * 2 |p3|  |  |  |  |
     * 1 |  |  |  |p4|  |
     * 0 |  |p5|  |  |  |
     *    0  1  2  3  4
     */
    @Test
    public void testCompareTo() throws InterruptedException {
        Point p1 = new Point(1, 4);
        Point p2 = new Point(4, 4);
        Point p3 = new Point(0, 2);
        Point p4 = new Point(3, 1);
        Point p5 = new Point(1, 0);
        assertEquals(1, p2.compareTo(p1));
        assertEquals(1, p1.compareTo(p3));
        assertEquals(1, p3.compareTo(p4));
        assertEquals(1, p4.compareTo(p5));
        assertEquals(0, p1.compareTo(p1));
        assertEquals(0, p2.compareTo(p2));
        assertEquals(0, p3.compareTo(p3));
        assertEquals(0, p4.compareTo(p4));
        assertEquals(0, p5.compareTo(p5));
        assertEquals(-1, p1.compareTo(p2));
        assertEquals(-1, p3.compareTo(p2));
        assertEquals(-1, p4.compareTo(p2));
        assertEquals(-1, p5.compareTo(p2));
    }

    /**
     * 4 |  |p1|  |  |p2|
     * 3 |  |  |  |  |  |
     * 2 |p3|  |  |  |  |
     * 1 |  |  |  |p4|  |
     * 0 |  |p5|  |  |  |
     *    0  1  2  3  4
     */
    @Test
    public void testSlopeTo() {
        Point p1 = new Point(1, 4);
        Point p2 = new Point(4, 4);
        Point p3 = new Point(0, 2);
        Point p4 = new Point(3, 1);
        Point p5 = new Point(1, 0);
        assertEquals(0d, p1.slopeTo(p2), 0.01);
        assertEquals(-1.5d, p4.slopeTo(p1), 0.01);
        assertEquals(1.33d, p5.slopeTo(p2), 0.01);
        assertEquals(Double.POSITIVE_INFINITY, p5.slopeTo(p1), 0.01);
        assertEquals(-0.33d, p3.slopeTo(p4), 0.01);
    }
}
