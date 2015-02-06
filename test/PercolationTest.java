import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testOpen() {
        Percolation subject = new Percolation(4);
        subject.open(2, 3);
        assertTrue(subject.isOpen(2, 3));
        subject.open(3, 2);
        assertTrue(subject.isOpen(3, 2));
        subject.open(3, 4);
        assertTrue(subject.isOpen(3, 4));
        subject.open(4, 3);
        assertTrue(subject.isOpen(4, 3));
        subject.open(3, 3);
        assertTrue(subject.isOpen(3, 3));
    }

    @Test
    public void testIsFull() {
        Percolation subject = new Percolation(4);
        subject.open(1, 2);
        assertTrue(subject.isFull(1, 2));
        subject.open(2, 2);
        assertTrue(subject.isFull(2, 2));
        subject.open(3, 2);
        assertTrue(subject.isFull(3, 2));
        subject.open(4, 2);
        assertTrue(subject.isFull(4, 2));
    }

    @Test
    public void testIsNotFull() {
        Percolation subject = new Percolation(4);
        assertFalse(subject.isFull(1, 2));
        assertFalse(subject.isFull(4, 4));
    }

    @Test
    public void testPercolates() {
        Percolation subject = new Percolation(4);
        subject.open(1, 4);
        subject.open(2, 2);
        subject.open(2, 3);
        subject.open(2, 4);
        subject.open(3, 2);
        subject.open(4, 1);
        subject.open(4, 2);
        assertTrue(subject.percolates());
    }

    @Test
    public void testNotPercolates() {
        Percolation subject = new Percolation(4);
        subject.open(1, 2);
        subject.open(2, 2);
        subject.open(3, 2);
        subject.open(4, 1);
        assertFalse(subject.percolates());
    }
}