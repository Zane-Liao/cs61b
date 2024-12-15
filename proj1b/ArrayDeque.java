import java.util.NoSuchElementException;
public class ArrayDeque<Item> implements Deque<Item> {
    /** ArrayDeque is not LinkedList. */
    private int size;
    private int nextFirst;
    private int nextLast;
    private Item[] items;

    private static final int RFCTOR = 2;

    /** index = -1, In the Computer Science,
     *  a[-1] -> a = [1, 2, 3, 4] -> [4] */
    public ArrayDeque() {
        size = 0;
        items = (Item[]) new Object[8];
        nextFirst = items.length / 2;
        nextLast = items.length / 2;
    }
    @Override
    public void addFirst(Item item) {
        if ((nextFirst == 0) && (!isFull())) nextFirst = items.length;
        items[nextFirst] = item;
        nextFirst -= 1;
        size += 1;
    }
    @Override
    public void addLast(Item item) {
        if ((nextLast == items.length) && (!isFull())) nextLast = 0;
        items[nextLast] = item;
        nextLast += 1;
        size += 1;
        if (isFull()) {
            resize(size*RFCTOR);
        }
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == items.length;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }
    @Override
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        if (nextFirst == items.length) nextFirst = 0;
        Item item = items[nextFirst];
        items[nextFirst] = null;
        nextFirst += 1;
        size -= 1;
        return item;
    }
    @Override
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");;
        if (nextLast == 0) nextLast = items.length;
        nextLast -= 1;
        Item item = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return item;
    }
    @Override
    public Item get(int index) {
        return items[calIndex(index)];
    }
    public int calIndex(int index) {
        int calIndex = (nextFirst + index) % items.length;
        return calIndex;
    }
    /** For example: [1, 2, 3, 4] -> [1, 2, null, null, null, null, 3, 4] */
    public void resize(int initialCapacity) {
        Item[] a = (Item[]) new Object[initialCapacity];
        int firstPartLength = items.length - nextFirst;
        System.arraycopy(items, nextFirst, a, 0, firstPartLength); // arraycopy
        System.arraycopy(items, 0, a, firstPartLength, nextLast);
        nextFirst = 0;
        nextLast = size;
        items = a;
    }
}