import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PercolationStatsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorLessThanZero() {
        PercolationStats subject = new PercolationStats(-1, 0);
    }

    @Test
    public void test200_100() {
        PercolationStats subject = new PercolationStats(200, 100);
        assertThat(subject.mean(), greaterThan(0.59d));
        assertThat(subject.mean(), lessThan(1d));
        assertThat(subject.stddev(), lessThan(0.015d));
        assertThat(subject.confidenceLo(), greaterThan(0.5d));
        assertThat(subject.confidenceHi(), greaterThan(0.5d));
    }

    @Test
    public void test2_10000() {
        PercolationStats subject = new PercolationStats(200, 100);
        assertThat(subject.mean(), greaterThan(0.5d));
        assertThat(subject.mean(), lessThan(1d));
        assertThat(subject.stddev(), lessThan(0.15d));
        assertThat(subject.confidenceLo(), greaterThan(0.5d));
        assertThat(subject.confidenceHi(), greaterThan(0.5d));
    }
}
