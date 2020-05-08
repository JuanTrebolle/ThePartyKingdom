package adapter;

public interface ValuableStorage<T> {
    void enqueue(T valuable);
    T dequeue();
    int size();
    T firstElement();
    boolean isEmpty();
    int indexOf(T valuable);
    boolean contains(T valuable);
}
