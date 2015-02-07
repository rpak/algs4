import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static junit.framework.Assert.assertEquals;
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
        subject.open(1, 2);
        assertFalse(subject.isFull(1, 3));
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

    @Test
    public void testTestFixtures() throws IOException {
        Object[][] fixtures = new Object[][] {
                {"greeting57", false},
                {"heart25", false},
                {"input1", true},
                {"input1-no", false},
                {"input2", true},
                {"input2-no", false},
                {"input3", true},
                {"input4", true},
                {"input5", true},
                {"input6", true},
                {"input7", true},
                {"input8", true},
                {"input8-no", false},
                {"input10", true},
                {"input10-no", false},
                {"input20", true},
                {"input50", true},
                {"jerry47", true},
                {"sedgewick60", true},
                {"wayne98", true}
        };

        for (int i = 0; i < fixtures.length; i++) {
            String fixturePath = "test/percolation/" + fixtures[i][0].toString() + ".txt";
            BufferedReader reader = new BufferedReader(new FileReader(fixturePath));
            int n = Integer.parseInt(reader.readLine());
            Percolation percolation = new Percolation(n);
            while (reader.ready()) {
                String[] coordinates = reader.readLine().trim().split("\\s+");
                if (coordinates.length < 2) continue;
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                percolation.open(x, y);
            }
            System.out.println(PercolationUtils.print(percolation, n));
            boolean expected = Boolean.parseBoolean(fixtures[i][1].toString());
            assertEquals("Fixture, " + fixtures[i][0], expected, percolation.percolates());
            reader.close();
        }
    }
}