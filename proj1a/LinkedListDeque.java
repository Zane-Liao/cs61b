import java.util.LinkedList;

public class LinkedListDeque<T> {
    public class Node {
        public T item;
        public Node next;
        public Node prev;
        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }
    private int size;
    private Node sentinel;
    private T t;

    public LinkedListDeque() {
        size = 1;
        sentinel = new Node(null,null, null);
    }

    public void addFirst(T item) {

    }
    public void addLast(T item) {}
    public boolean isEmpty() {}
    public int size() {}
    public void printDeque() {}
    public T removeFirst() {}
    public T removeLast() {}
    public T get(int index) {}
    public T getRecursive(int index) {}
}
