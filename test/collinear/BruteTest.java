import org.junit.Test;

public class BruteTest {

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
    }

    @Test
    public void testInput8() {
        Brute.main(new String[] {"test/collinear/input8.txt"});
    }

    @Test
    public void testInput200() {
        Brute.main(new String[] {"test/collinear/input200.txt"});
    }

    @Test
    public void testInputRS1423() {
        Brute.main(new String[] {"test/collinear/rs1423.txt"});
    }
}
