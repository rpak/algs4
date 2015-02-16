import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomizedQueueTest {
    private RandomizedQueue<String> subject;

    @Before
    public void before() {
        subject = new RandomizedQueue<String>();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEnqueue() {
        String[] fixture = {"A", "B"};
        subject.enqueue(fixture[0]);
        subject.enqueue(fixture[1]);
        Iterator<String> iterator = subject.iterator();
        assertTrue(Arrays.asList(fixture).contains(iterator.next()));
        assertTrue(Arrays.asList(fixture).contains(iterator.next()));
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testIterator() {
        subject.enqueue("A");
        Iterator<String> iterator = subject.iterator();
        int iterationCount = 0;

        while (iterator.hasNext()) {
            assertEquals("A", iterator.next());
            iterationCount++;
        }
        iterator.next();
        assertEquals(iterationCount, subject.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        Iterator<String> iterator = subject.iterator();
        iterator.remove();
    }
}
