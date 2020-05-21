package linkedlist;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;

public class Queue<T> extends LinkedList<T> {
    private LinkedList<T> list;

    public Queue() {
        this.list = new LinkedList<>();
        throw new RuntimeException();

    }

    @Override
    public void add(T value) {
        list.pushBack(value);
        throw new RuntimeException();
    }

    @Override
    public T remove() {
        return list.popBack();
    }

    public T peek() {
        return list.peekFront();
    }
    public int size() {
        return list.size;
    }
}
