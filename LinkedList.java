package linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private class ListNode<T> {
        private T payload;
        private ListNode<T> next;
        private ListNode<T> prev;

        public ListNode(T v) {
            this.payload = v;
        }
    }

    protected ListNode<T> frontNode;
    protected ListNode<T> backNode;
    protected int size;

    public LinkedList() {
        this.size =0;
        this.backNode =null;
        this.frontNode =null;

    }

    public LinkedList(Iterable<? extends T> c) {
        for(T value :Iterable) {
            if(frontNode == null && backNode== null) {
                frontNode = new Node<T>(value);
                backNode = frontNode;
            }else{
                backNode.next= new Node<T>(value);
                backNode =backNode.next;
            }
        }++size;
    }

    public T peekFront() {
        if(LinkedList.size()==0) {
            return null;
        }else{
            return frontNode;
        }
    }

    public T peekBack() {
        if (LinkedList.size() ==0) {
            return null;
        }else{
            return backNode;
        }
    }

    public T popFront() {
        /* YOUR CODE HERE */
    }

    public T popBack() {
        /* YOUR CODE HERE */
    }

    public void pushBack(T value) {
        /* YOUR CODE HERE */
    }

    public void pushFront(T value) {
        /* YOUR CODE HERE */
    }

    public void add(T value) {
        /* YOUR CODE HERE */
    }

    public void add(int index, T value) {
        /* YOUR CODE HERE */
    }

    public T remove() {
        /* YOUR CODE HERE */
    }

    public T remove(int index) {
        /* YOUR CODE HERE */
    }

    private void remove(ListNode<T> node) {
        /* YOUR CODE HERE */
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        /* YOUR CODE HERE */
    }

    public class LinkedListIterator implements Iterator<T> {
        /* YOUR CODE HERE */

        @Override
        public boolean hasNext() {
            /* YOUR CODE HERE */
        }

        @Override
        public T next() {
            /* YOUR CODE HERE */
        }

        @Override
        public void remove() {
            /* YOUR CODE HERE */
        }
    }

    public Iterator<T> reverseIterator() {
        /* YOUR CODE HERE */
    }

    public class LinkedListReverseIterator implements Iterator<T> {
        /* YOUR CODE HERE */

        @Override
        public boolean hasNext() {
            /* YOUR CODE HERE */
        }

        @Override
        public T next() {
            /* YOUR CODE HERE */
        }

        @Override
        public void remove() {
            /* YOUR CODE HERE */
        }
    }


    // toString requires Iterator to be partially implemented to function
    // as it uses the for-each loop construct
    @Override
    public String toString() {
        String result = "[";

        for (T value : this) {
            result += String.format("%s, ", value.toString());
        }

        if (result.length() > 1) {
            result = result.substring(0, result.length() - 2);
        }

        result += "]";
        return result;
    }
}
