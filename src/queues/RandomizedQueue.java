import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int length;
    private int nextIndex;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.items = (Item[]) new Object[2];
        this.length = 0;
        this.nextIndex = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // return the number of items on the queue
    public int size() {
        return this.length;
    }

    // add the item
    public void enqueue(Item item) {
        // if (size() == items.length) resize(2 * items.length);
        this.items[nextIndex] = item;
        this.nextIndex++;
        this.length++;
    }

    // delete and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        if (size() > 0 && size() == items.length / 4) resize(items.length / 2);
        this.length--;

        int index = StdRandom.uniform(this.length);
        Item randomItem = sample();
        if (this.items[index] == null) {

        }
        return null;
    }

    private void resize(int size) {

    }

    // return (but do not delete) a random item
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return null;
    }

    private int sampleIndex() {
        int randomIndex = -1;
        while (randomIndex <= -1) {
            int candidate = StdRandom.uniform(this.items.length);
            if (this.items[candidate] != null) {
                randomIndex = candidate;
            }
        }

        return randomIndex;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // unit testing
    public static void main(String[] args) {

    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] iteratee;
        private int iterationIndex;

        public RandomizedQueueIterator() {
            this.iterationIndex = 0;
            this.iteratee = (Item[]) new Object[size()];

            int currentIndex = 0;
            for (Item item : items) {
                if (item == null) continue;
                this.iteratee[currentIndex] = item;
                currentIndex++;
            }
            StdRandom.shuffle(this.iteratee);
        }

        @Override
        public boolean hasNext() {
            return this.iterationIndex < this.iteratee.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item nextItem = this.iteratee[this.iterationIndex];
            this.iterationIndex++;
            return nextItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
