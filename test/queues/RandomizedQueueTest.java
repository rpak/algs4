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

    public void testEnqueue() {
        String[] fixture = {"A", "B", "C"};
        subject.enqueue(fixture[0]);
        subject.enqueue(fixture[1]);
        subject.enqueue(fixture[2]);
        Iterator<String> iterator = subject.iterator();
        assertTrue(Arrays.asList(fixture).contains(iterator.next()));
        assertTrue(Arrays.asList(fixture).contains(iterator.next()));
        assertTrue(Arrays.asList(fixture).contains(iterator.next()));
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeue() {
        String[] fixture = {"A", "B", "C"};
        subject.enqueue(fixture[0]);
        subject.enqueue(fixture[1]);
        subject.enqueue(fixture[2]);
        assertTrue(Arrays.asList(fixture).contains(subject.dequeue()));
        assertTrue(Arrays.asList(fixture).contains(subject.dequeue()));
        assertTrue(Arrays.asList(fixture).contains(subject.dequeue()));
        assertTrue(subject.isEmpty());
        subject.enqueue(fixture[0]);
        assertTrue(Arrays.asList(fixture).contains(subject.dequeue()));
        subject.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void testSample() {
        String[] fixture = {"A", "B", "C"};
        assertTrue(Arrays.asList(fixture).contains(subject.sample()));
        assertTrue(Arrays.asList(fixture).contains(subject.sample()));
        assertTrue(Arrays.asList(fixture).contains(subject.sample()));
        assertTrue(Arrays.asList(fixture).contains(subject.sample()));
        assertTrue(Arrays.asList(fixture).contains(subject.sample()));
        subject.dequeue();
        subject.dequeue();
        subject.dequeue();
        subject.sample();
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

    @Test(expected = NoSuchElementException.class)
    public void testIteratorEmpty() {
        Iterator<String> iterator = subject.iterator();
        iterator.next();
    }
}
