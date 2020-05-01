package adapter;

import flyweight.Valuable;

public interface ValuableStorage {
    void enqueue(Valuable valuable);
    Valuable dequeue();
    int size();
    Valuable firstElement();
    boolean isEmpty();
    int indexOf(Valuable valuable);
    boolean contains(Valuable valuable);
}
