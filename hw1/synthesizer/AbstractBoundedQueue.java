package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    @Override
    public int capacity() {
        return capacity;
    }
    @Override
    public int fillCount() {
        return fillCount;
    }
//    protected abstract boolean isEmpty();
//    protected abstract boolean isFull();
//    protected abstract T peek();
//    protected abstract T dequeue();
//    protected abstract void enqueue(T x);
}
