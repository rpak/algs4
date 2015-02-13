import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Queue<Item> queue;
    private Stack<Item> stack;

    // construct an empty deque
    public Deque() {
        this.queue = new Queue<Item>();
        this.stack = new Stack<Item>();
        this.length = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.queue.size() == 0 && this.stack.size() == 0;
    }

    // return the number of items on the deque
    public int size() {
        return this.queue.size() + this.stack.size();
    }

    // insert the item at the front
    public void addFirst(Item item) {
        this.stack.push(item);
    }

    // insert the item at the end
    public void addLast(Item item) {
        this.queue.enqueue(item);
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (this.stack.isEmpty() && this.queue.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        else if (this.stack.isEmpty()) {
            this.stack.push(this.queue.dequeue());
        }

        return this.stack.pop();
    }

    // delete and return the item at the end
    public Item removeLast() {
        return this.queue.dequeue();
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator(this.stack, this.queue);
    }

    // unit testing
    public static void main(String[] args) {

    }

    private class DequeIterator implements Iterator<Item> {
        private Queue<Item> items;

        public DequeIterator(Stack<Item> stack, Queue<Item> queue) {
            this.items = new Queue<Item>();
            Iterator<Item> stackIterator = stack.iterator();
            Iterator<Item> queueIterator = queue.iterator();
            Item currentItem = null;

            while (stackIterator.hasNext()) {
                currentItem = stackIterator.next();
                // if (queueIterator.hasNext() && queueIterator.next() == stackItem) break;
                items.enqueue(currentItem);
            }

            while (queueIterator.hasNext()) {
                currentItem = queueIterator.next();
                // if (stackIterator.hasNext() && stackIterator.next() == currentItem) break;
                items.enqueue(currentItem);
            }
        }

        @Override
        public boolean hasNext() {
            return items.size() != 0;
        }

        @Override
        public Item next() {
            return items.dequeue();
        }

        @Override
        public void remove() {}
    };
}