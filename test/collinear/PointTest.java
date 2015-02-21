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
        // (x0 = 4, y0 = 4) (x1 = 1, y1 = 4); 4 < 4  || 4 == 4 &&  4 < 1)
        assertEquals(1, p2.compareTo(p1));
        assertEquals(1, p1.compareTo(p3));
        assertEquals(1, p3.compareTo(p4));
        assertEquals(1, p4.compareTo(p5));
        // (x0 = 1, y0 = 4) (x1 = 1, y1 = 4); 4 < 4  || 4 == 4 &&  1 < 1)
        assertEquals(0, p1.compareTo(p1));
        assertEquals(0, p2.compareTo(p2));
        assertEquals(0, p3.compareTo(p3));
        assertEquals(0, p4.compareTo(p4));
        assertEquals(0, p5.compareTo(p5));
        // (x0 = 1, y0 = 4) (x1 = 4, y1 = 4); 4 < 4  || 4 == 4 &&  1 < 4)
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
        Point px = new Point(1, 4);
        assertEquals(+0d, p1.slopeTo(p2), 0.01);
        // (x0 = 3, y0 = 1) (x1 = 1, y1 = 4) s = (4 - 1) / (1 - 3)
        assertEquals(-1.5d, p4.slopeTo(p1), 0.01);
        assertEquals(1.33d, p5.slopeTo(p2), 0.01);
        assertEquals(Double.POSITIVE_INFINITY, p5.slopeTo(p1), 0.01);
        assertEquals(-0.33d, p3.slopeTo(p4), 0.01);
        assertEquals(Double.NEGATIVE_INFINITY, p1.slopeTo(px), 0.01);
    }

    @Test
    public void testPositiveInfinity() {
        Point p1 = new Point(24105, 24244);
        Point p2 = new Point(24105, 19115);
        assertEquals(Double.POSITIVE_INFINITY, p1.slopeTo(p2), 0.01);
    }

    @Test
    public void testPositiveZero() {
        Point p1 = new Point(462, 113);
        Point p2 = new Point(188, 113);
        assertEquals(Double.doubleToRawLongBits(+0.0), Double.doubleToRawLongBits(p1.slopeTo(p2)), 0.01);
        Point p3 = new Point(25316, 4212);
        Point p4 = new Point(5364, 4212);
        System.out.println(p3.slopeTo(p4));
        assertEquals(Double.doubleToRawLongBits(+0.0), Double.doubleToRawLongBits(p3.slopeTo(p4)), 0.01);
    }

    /**
     * 4 |  |p3|  |  |p2|
     * 3 |  |  |  |  |  |
     * 2 |  |  |  |  |  |
     * 1 |  |  |  |p4|  |
     * 0 |  |p1|  |  |  |
     *    0  1  2  3  4
     */
    @Test
    public void testSlopeOrder() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(4, 4);
        Point p3 = new Point(1, 4);
        Point p4 = new Point(3, 1);

        /**
         * Invoking point p1 (x0 = 1, y0 = 0)
         * Point p2 (x1 = 4, y1 = 4)
         * Point p4 (x2 = 3, y2 = 1)
         *
         * (y1 - y0) / (x1 - x0) < (y2 - y0) / (x2 - x0)
         * (4  - 0 ) / (4  - 1 ) < (1  - 0 ) / (3  - 1 )
         * 1.33 < 0.5
         */
        assertEquals(1, p1.SLOPE_ORDER.compare(p2, p4));
        assertEquals(-1, p1.SLOPE_ORDER.compare(p4, p2));
        assertEquals(0, p1.SLOPE_ORDER.compare(p2, p2));
        assertEquals(1, p1.SLOPE_ORDER.compare(p3, p2));
    }
}
