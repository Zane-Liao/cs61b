import java.util.NoSuchElementException;
public class ArrayDeque<T> {
    /** ArrayDeque is not LinkedList. */
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    private static final int RFCTOR = 2;

    /** index = -1, In the Computer Science,
     *  a[-1] -> a = [1, 2, 3, 4] -> [4] */
    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = items.length / 2;
        nextLast = items.length / 2;
    }
    public void addFirst(T item) {
        if ((nextFirst == 0) && (!isFull())) nextFirst = items.length;
        items[nextFirst] = item;
        nextFirst -= 1;
        size += 1;
    }
    public void addLast(T item) {
        if ((nextLast == items.length) && (!isFull())) nextLast = 0;
        nextLast += 1;
        items[nextLast] = item;
        size += 1;
        if (isFull()) {
            resize(size*RFCTOR);
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == items.length;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        if (nextFirst == items.length) nextFirst = 0;
        T item = items[nextFirst];
        items[nextFirst] = null;
        nextFirst += 1;
        size -= 1;
        return item;
    }
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");;
        if (nextLast == 0) nextLast = items.length;
        nextLast -= 1;
        T item = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return item;
    }
    public T get(int index) {
        return items[calIndex(index)];
    }
    public int calIndex(int index) {
        int calIndex = (nextFirst + index) % items.length;
        return calIndex;
    }
    /** For example: [1, 2, 3, 4] -> [1, 2, null, null, null, null, 3, 4] */
    public void resize(int initialCapacity) {
        T[] a = (T[]) new Object[initialCapacity];
        int firstPartLength = items.length - nextFirst;
        System.arraycopy(items, nextFirst, a, 0, firstPartLength); // arraycopy
        System.arraycopy(items, 0, a, firstPartLength, nextLast);
        nextFirst = 0;
        nextLast = size;
        items = a;
    }
}