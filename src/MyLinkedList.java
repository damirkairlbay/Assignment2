import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int count;

    public MyLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    public T get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException("Index out of range");
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void remove(int index) {
        
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
