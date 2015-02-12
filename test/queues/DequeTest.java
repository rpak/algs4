import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assert(subject.iterator().next().equals("A"));
        assert(subject.iterator().next().equals("B"));
        assert(subject.iterator().next().equals("C"));
        assert(subject.iterator().next().equals("D"));
    }

    @Test
    public void testAddFirst() {
        subject.addFirst("foo");
        subject.addFirst("bar");
        subject.addFirst("baz");
        assert(subject.iterator().next().equals("foo"));
        assert(subject.iterator().next().equals("bar"));
        assert(subject.iterator().next().equals("baz"));
    }

    @Test
    public void testAddLast() {
        subject.addLast("foo");
        subject.addLast("bar");
        subject.addLast("baz");
        assert(subject.iterator().next().equals("foo"));
        assert(subject.iterator().next().equals("bar"));
        assert(subject.iterator().next().equals("baz"));
    }

    @Test
    public void testRemoveFirst() {

    }

    @Test
    public void testRemoveLast() {

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
        assertTrue(iterationCount == subject.size());
    }

    @Test
    public void testMain() {}
}
