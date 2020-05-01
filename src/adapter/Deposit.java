package adapter;

import flyweight.Valuable;

import java.util.ArrayList;


/*Adapter. The Adaptee is the Arraylist, which we delegate the work to*/
public class Deposit implements ValuableStorage {
    ArrayList<Valuable> listOfValuables;
    private int maxSize;

    public Deposit(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void enqueue(Valuable valuable) {
        if (listOfValuables.size() >= maxSize){
            throw new IllegalStateException("Ain't no room for that gold...");
        }
        if (valuable == null){
            throw new IllegalArgumentException("No more gold");
        }
        listOfValuables.add(valuable);
    }

    @Override
    public Valuable dequeue() {
        return listOfValuables.remove(0);
    }

    @Override
    public int size() {
        return listOfValuables.size();
    }

    @Override
    public Valuable firstElement() {
        if (listOfValuables.size() == 0){
            throw new IllegalStateException("Queue empty");
        }
        return listOfValuables.get(0);
    }

    @Override
    public boolean isEmpty() {
        return listOfValuables.isEmpty();
    }

    @Override
    public int indexOf(Valuable valuable) {
        return listOfValuables.indexOf(valuable);
    }

    @Override
    public boolean contains(Valuable valuable) {
        return listOfValuables.contains(valuable);
    }
}
