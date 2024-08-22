package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;
    public abstract int capacity();
    public abstract int fillCount();
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract T peek();
    public abstract T dequeue();
    public abstract void enqueue(T x);
}
