package adapter;

import utility.collection.ArrayList;

/*Adapter. The Adaptee is the Arraylist, which we delegate the work to*/

public class Deposit<T> implements ValuableStorage<T>{

    private ArrayList<T> listOfValuables;
    private int maxSize;

    public Deposit(int maxSize) {
        this.listOfValuables = new ArrayList<>();
        this.maxSize = maxSize;
    }

    @Override
    public synchronized void enqueue(T valuable) {
        if (listOfValuables.size() >= maxSize){
            throw new IllegalStateException("Ain't no room for that gold...");
        }
        if (valuable == null){
            throw new IllegalArgumentException("No more gold");
        }
        listOfValuables.add(valuable);
    }

    @Override
    public synchronized T dequeue() {
        return listOfValuables.remove(0);
    }

    @Override
    public int size() {
        return listOfValuables.size();
    }

    @Override
    public T firstElement() {
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
    public int indexOf(T valuable) {
        return listOfValuables.indexOf(valuable);
    }

    @Override
    public boolean contains(T valuable) {
        return listOfValuables.contains(valuable);
    }
}
