import java.util.LinkedList;

public class LinkedListDeque<T> {
    public static class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> prev;
        public Node(Node<T> p, T i, Node<T> n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private int size;
    private Node<T> sentFront;
    private Node<T> sentBack;
    private T t;

    public LinkedListDeque() {
        sentFront = new Node<T>(null, null, null);
        sentBack = new Node<T>(null, null, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        size = 0;
    }

    public void addFirst(T item) {
        Node<T> newnode = new Node<T>(sentFront, item, sentFront.next);
        sentFront.next.prev = newnode;
        sentFront.next = newnode;
        size += 1;
    }

    public void addLast(T item) {
        Node<T> newnode = new Node<T>(sentBack, item, sentBack.prev);
        sentBack.prev.next = newnode;
        sentBack.prev = newnode;
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {}
    public T removeFirst() {
        Node<T> first = sentFront.next;
        T item = first.item;
        sentFront.next = sentFront;
        first.prev.next = sentFront;
        size -= 1;
        return item;
    }
    public T removeLast() {
        Node<T> last = sentBack.prev;
        T item = last.item;
        sentBack.prev = sentBack;
        last.next.prev = sentBack;
        size -= 1;
        return item;
    }
    public T get(int index) {
        Node<T> first = sentFront.next;
        for (int i = 0; i < index; i++) {
            first = first.next;
            i++;
        }
        return first.item;
    }
    public T getRecursive(int index) {
        Node<T> first = sentFront.next;
        if (first == null) {
            return first.item;
        }
        return getRecursive(index - 1);
    }
}
