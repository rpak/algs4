import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class DequeTest {
    private Deque<String> subject;

    @Before
    public void before() {
        subject = new Deque<String>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(subject.isEmpty());
        subject.addFirst("foo");
        assertFalse(subject.isEmpty());
    }

    @Test
    public void testSize() {
        assertTrue(subject.size() == 0);
        subject.addFirst("foo");
        assertTrue(subject.size() == 1);
    }

    @Test
    public void testAdd() {
        subject.addFirst("B");
        subject.addLast("C");
        subject.addFirst("A");
        subject.addLast("D");
        Iterator<String> iterator = subject.iterator();
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertEquals("D", iterator.next());
    }

    @Test
    public void testAddFirst() {
        subject.addFirst("foo");
        subject.addFirst("bar");
        subject.addFirst("baz");
        Iterator<String> iterator = subject.iterator();
        assertEquals("baz", iterator.next());
        assertEquals("bar", iterator.next());
        assertEquals("foo", iterator.next());
    }

    @Test
    public void testAddLast() {
        subject.addLast("foo");
        subject.addLast("bar");
        subject.addLast("baz");
        Iterator<String> iterator = subject.iterator();
        assertEquals("foo", iterator.next());
        assertEquals("bar", iterator.next());
        assertEquals("baz", iterator.next());
    }

    @Test
    public void testRemoveFirst() {
        subject.addFirst("A");
        assertEquals("A", subject.removeFirst());
        subject.addFirst("B");
        subject.addFirst("C");
        subject.addLast("D");
        assertEquals("C", subject.removeFirst());
        assertEquals("B", subject.removeFirst());
        assertEquals("D", subject.removeFirst());
    }

    @Test
    public void testRemoveLast() {
        subject.addLast("A");
        subject.addLast("B");
        subject.addLast("C");
        subject.addFirst("D");
        subject.addFirst("E");
        assertEquals("C", subject.removeLast());
        assertEquals("B", subject.removeLast());
        assertEquals("A", subject.removeLast());
        assertEquals("D", subject.removeLast());
        assertEquals("E", subject.removeLast());
    }

    @Test
    public void testIterator() {
        subject.addFirst("foo");
        subject.addFirst("bar");
        Iterator<String> iterator = subject.iterator();
        int iterationCount = 0;

        while (iterator.hasNext()) {
            String next = iterator.next();
            assertTrue(next.equals("foo") || next.equals("bar"));
            iterationCount++;
        }
        assertEquals(iterationCount, subject.size());
    }

    @Test
    public void testMain() {}
}
