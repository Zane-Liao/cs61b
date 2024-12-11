public class ArrayDeque<V> {
    /** ArrayDeque is not LinkedList. */
    private int size;
    private int nextFirst;
    private int nextLast;
    private V[] items;

    private static final int RFCTOR = 2;

    /** index = -1, In the Computer Science,
     *  a[-1] -> a = [1, 2, 3, 4] -> [4] */
    public ArrayDeque() {
        size = 0;
        items = (V[]) new Object[8];
        nextFirst = 0;
        nextLast = 0;
    }
    public void addFirst(V item) {
        items[nextFirst] = item;
        nextFirst += (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }
    public void addLast(V item) {
        if (isFull()) {
            resize(size*RFCTOR);
        }
        nextLast += (nextLast + 1) % items.length;
        items[nextLast] = item;
        size += 1;
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
    public V printDeque() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
        return null;
    }
    public V removeFirst() {
        if (items.length / size >= 4 || items.length > 16) {
            resize(items.length / 4);
        }
        items[size - 1] = null;
        nextFirst -= (nextFirst + 1) % items.length;
        size -= 1;
        return null;
    }
    public V removeLast() {
        items[size - 1] = null;
        nextLast -= (nextLast - 1 + items.length) % items.length;
        size -= 1;
        return null;
    }
    public V get(int index) {
        return items[calIndex(index)];
    }
    public int calIndex(int index) {
        int calIndex = (nextFirst + index) % items.length;
        return calIndex;
    }
    public void resize(int initialCapacity) {
        V[] a = (V[]) new Object[initialCapacity];
        System.arraycopy(items, 0, a, 0, size);
        nextFirst = 0;
        nextLast = size;
        items = a;
    }
}
