import org.junit.Test;
import org.junit.*;

public class PercolationTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorLessThanZero() {
        Percolation subject = new Percolation(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOpenBounds() {
        Percolation subject = new Percolation(20);
        subject.open(21, 21);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsOpenBounds() {
        Percolation subject = new Percolation(20);
        subject.isOpen(21, 21);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsFullBounds() {
        Percolation subject = new Percolation(20);
        subject.isFull(21, 21);
    }
}