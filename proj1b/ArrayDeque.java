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
        nextFirst = 0;
        nextLast = 0;
    }
    @Override
    public void addFirst(Item item) {
        if (isFull()) {
            resize(size*RFCTOR);
        }
        items[nextFirst] = item;
        nextFirst += (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }
    @Override
    public void addLast(Item item) {
        if (isFull()) {
            resize(size*RFCTOR);
        }
        nextLast += (nextLast + 1) % items.length;
        items[nextLast] = item;
        size += 1;
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
        if (items.length / size >= 4 || items.length > 16) {
            resize(items.length / 4);
        }
        items[size - 1] = null;
        nextFirst -= (nextFirst + 1) % items.length;
        size -= 1;
        return null;
    }
    @Override
    public Item removeLast() {
        items[size - 1] = null;
        nextLast -= (nextLast - 1 + items.length) % items.length;
        size -= 1;
        return null;
    }
    @Override
    public Item get(int index) {
        return items[calIndex(index)];
    }
    public int calIndex(int index) {
        int calIndex = (nextFirst + index) % items.length;
        return calIndex;
    }
    public void resize(int initialCapacity) {
        Item[] a = (Item[]) new Object[initialCapacity];
        System.arraycopy(items, 0, a, 0, size);
        nextFirst = 0;
        nextLast = size;
        items = a;
    }
}