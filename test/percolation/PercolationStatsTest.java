import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class PercolationStatsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorLessThanZero() {
        PercolationStats subject = new PercolationStats(-1, 0);
    }

    @Test
    public void test200_100() {
        PercolationStats subject = new PercolationStats(200, 100);
        MatcherAssert.assertThat(subject.mean(), greaterThan(0.59d));
        MatcherAssert.assertThat(subject.mean(), lessThan(1d));
        MatcherAssert.assertThat(subject.stddev(), lessThan(0.015d));
        MatcherAssert.assertThat(subject.confidenceLo(), greaterThan(0.5d));
        MatcherAssert.assertThat(subject.confidenceHi(), greaterThan(0.5d));
    }

    @Test
    public void test2_10000() {
        PercolationStats subject = new PercolationStats(200, 100);
        MatcherAssert.assertThat(subject.mean(), greaterThan(0.5d));
        MatcherAssert.assertThat(subject.mean(), lessThan(1d));
        MatcherAssert.assertThat(subject.stddev(), lessThan(0.15d));
        MatcherAssert.assertThat(subject.confidenceLo(), greaterThan(0.5d));
        MatcherAssert.assertThat(subject.confidenceHi(), greaterThan(0.5d));
    }
}
