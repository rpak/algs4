import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BruteTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    /**
     * [0] (1234, 5678)
     * [1] (14000, 10000)
     * [2] (18000, 10000)
     * [3] (19000, 10000)
     * [4] (21000, 10000)
     * [5] (32000, 10000)
     */
    @Test
    public void testInput6() {
        Brute.main(new String[] {"test/collinear/input6.txt"});
        assertEquals(
                "(14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (21000, 10000)\n" +
                "(14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (32000, 10000)\n" +
                "(14000, 10000) -> (18000, 10000) -> (21000, 10000) -> (32000, 10000)\n" +
                "(14000, 10000) -> (19000, 10000) -> (21000, 10000) -> (32000, 10000)\n" +
                "(18000, 10000) -> (19000, 10000) -> (21000, 10000) -> (32000, 10000)\n",
                outputStream.toString());
    }

    @Test
    public void testInput8() {
        Brute.main(new String[] {"test/collinear/input8.txt"});
        assertEquals(
                "(10000, 0) -> (7000, 3000) -> (3000, 7000) -> (0, 10000)\n" +
                "(3000, 4000) -> (6000, 7000) -> (14000, 15000) -> (20000, 21000)\n",
                outputStream.toString());
    }

    @Test
    public void testInput200() {
        Brute.main(new String[] {"test/collinear/input200.txt"});
    }
}
