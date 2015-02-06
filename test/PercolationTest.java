import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;
import org.junit.Assert;

public class PercolationTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorLessThanZero() {
        Percolation subject = new Percolation(-1);
    }
}