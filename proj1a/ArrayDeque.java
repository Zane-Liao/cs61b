public class ArrayDeque<V> {
    public class Node {
        public Node nextFirst;
        public Node nextLast;
        public Node( Node f, Node n) {
            nextFirst = f;
            nextLast = n;
        }
    }

    private int size;
    private V[] items;

    public ArrayDeque() {
        size = 0;
        items = (V[]) new Object[8];
    }
    public void addFirst(V item) {

    }
    public void addLast(V item) {}
    public boolean isEmpty() {}
    public int size() {}
    public void printDeque() {}
    public V removeFirst() {}
    public V removeLast() {}
    public V get(int index) {}
    public V getRecursive(int index) {}
}
