package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private class ListNode<T> {
        private T payload;
        private ListNode<T> next;
        private ListNode<T> prev;

        public ListNode(T v) {
            this.payload = v;
            this.next = null;
            this.prev = null;
        }
    }

    protected ListNode<T> frontNode;
    protected ListNode<T> backNode;
    protected int size;

    public LinkedList() {
        this.size = 0;
        this.backNode = null;
        this.frontNode = null;

    }

    public LinkedList(Iterable<? extends T> c) {
        for(T value :c) {
            if(frontNode == null ) {
                frontNode = new ListNode<T>(value);
                backNode = frontNode;
            } else if(frontNode==backNode) {
                backNode= new ListNode <T>(value);
                frontNode.next = backNode;
                backNode.prev = frontNode;
            } else{
                ListNode<T> node= backNode;
                backNode= new ListNode<T>(value);
                backNode.prev= node;
                node.next= backNode;

            }
        size++;
        }
    }

    public T peekFront() {
        if(size == 0) {
            return null;
        } else {
            return frontNode.payload;
        }
    }

    public T peekBack() {
        if (size == 0) {
            return null;
        } else {
            return backNode.payload;
        }
    }

    public T popFront() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        } else {
            return this.remove(0);
        }
    }

    public T popBack() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        } else {
            return this.remove(this.size - 1);
        }
    }

    public void pushBack(T value) {
        ListNode<T> newNode = new ListNode<T>(value);
        newNode.next = null;
        if (this.frontNode == null) {
            newNode.prev = null;
            this.frontNode = newNode;
            this.backNode = newNode;
        } else {
            newNode.prev = this.backNode;
            this.backNode.next = newNode;
            this.backNode = newNode;
        }
        this.size++;
    }

    public void pushFront(T value) {
        ListNode<T> newNode = new ListNode<T>(value);
        newNode.prev = null;
        if (this.size == 0) {
            newNode.next = null;
            this.frontNode = newNode;
            this.backNode = newNode;
        } else {
            newNode.next = this.frontNode;
            this.frontNode.prev = newNode;
            this.frontNode = newNode;
        }
        this.size++;
    }


    public void add(T value) {
        this.pushFront(value);
    }

    public void add(int index, T value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }else if(index == 0) {
            this.pushFront(value);
        }else if(index==size) {
            this.pushBack(value);
        }else {
            ListNode<T> current= this.frontNode;
            for (int i = 0; i < index; ++i) {
                if (current != null) {
                    current = current.next;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            ListNode<T> temp = current;
            current = new ListNode<T> (value);
            current.next= temp;
            current.prev= temp.prev;
            temp.prev.next =current;
            temp.prev= current;
            ++this.size;
        }
    }

    public T remove() {
       return popFront();
    }

    public T remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            ListNode<T> removeNode = this.frontNode;
            for (int loop = 0; loop < index; loop++) {
                if (removeNode.next == null) {
                    throw new IndexOutOfBoundsException();
                } else {
                    removeNode = removeNode.next;
                }
            }
            if (removeNode.prev != null) {
                removeNode.prev.next = removeNode.next;
            } else {
                this.frontNode = removeNode.next;
            }
            if (removeNode.next != null) {
                removeNode.next.prev = removeNode.prev;
            } else {
                this.backNode = removeNode.prev;
            }
            this.size--;
            return removeNode.payload;
        }
    }

    private void remove(ListNode<T> node) {

    }

    public int size(){
        return this.size;
    }

    @Override
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<T> {
        private ListNode<T> itNode = frontNode;
        private ListNode<T> prNode = null;

        @Override
        public boolean hasNext() {
            return (itNode != null);
        }

        @Override
        public T next() {
            T value = null;
            if (this.itNode != null) {
                value = this.itNode.payload;
                this.prNode = this.itNode;
                itNode = itNode.next;
            } else {
                throw new NoSuchElementException();
            }
            return value;
        }

        @Override
        public void remove() {
            if (this.prNode != null) {
                if (this.prNode.next != null) {
                    this.prNode.next.prev = this.prNode.prev;
                } else {
                    backNode = this.prNode.prev;
                }
                if (this.prNode.prev != null) {
                    this.prNode.prev.next = this.prNode.next;
                } else {
                    frontNode = this.prNode.next;
                }
                size--;
            } else {
                throw new IllegalStateException();
            }
        }

    }

    public Iterator<T> reverseIterator() {
        return new LinkedListReverseIterator();
    }

    public class LinkedListReverseIterator implements Iterator<T> {
        private ListNode<T> itNode = backNode;
        private ListNode<T> prNode = null;

        @Override
        public boolean hasNext() {
            return (itNode != null);
        }

        @Override
        public T next() {
            T value = null;
            if (this.itNode != null) {
                value = this.itNode.payload;
                this.prNode = this.itNode;
                this.itNode = this.itNode.prev;
            } else {
                throw new NoSuchElementException();
            }
            return value;
        }

        @Override
        public void remove() {
            if (this.prNode != null) {
                if (this.prNode.next != null) {
                    this.prNode.next.prev = this.prNode.prev;
                } else {
                    backNode = this.prNode.prev;
                }
                if (this.prNode.prev != null) {
                    this.prNode.prev.next = this.prNode.next;
                } else {
                    frontNode = this.prNode.next;
                }
                size--;
            } else {
                throw new IllegalStateException();
            }
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
