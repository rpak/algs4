import org.junit.Test;

public class PercolationStatsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorLessThanZero() {
        PercolationStats subject = new PercolationStats(-1, 0);
    }
}
