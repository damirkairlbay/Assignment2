import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T element) {
            this.item = element;
        }
    }

    public void add(T item) {
        Node<T> l = tail;
        Node<T> newNode = new Node<>(item);
        tail = newNode;
        if (l == null) head = newNode;
        else {
            l.next = newNode;
            newNode.prev = l;
        }
        size++;
    }

    public void add(int index, T item) {
        Node<T> target = (index == size) ? null : node(index);
        Node<T> prev = (target == null) ? tail : target.prev;
        Node<T> newNode = new Node<>(item);
        newNode.next = target;
        newNode.prev = prev;
        if (target == null) tail = newNode;
        else target.prev = newNode;
        if (prev == null) head = newNode;
        else prev.next = newNode;
        size++;
    }

    public void addFirst(T item) {
        Node<T> h = head;
        Node<T> newNode = new Node<>(item);
        head = newNode;
        if (h == null) tail = newNode;
        else {
            h.prev = newNode;
            newNode.next = h;
        }
        size++;
    }

    public void addLast(T item) {
        add(item);
    }

    public T get(int index) {
        return node(index).item;
    }

    public T getFirst() {
        return head.item;
    }

    public T getLast() {
        return tail.item;
    }

    public T remove(int index) {
        remove(node(index));
        return null;
    }

    public void removeFirst() {
        remove(head);
    }

    public void removeLast() {
        remove(tail);
    }

    public void sort() {
        if (size > 1) {
            boolean wasChanged;
            do {
                Node<T> current = head;
                wasChanged = false;
                while (current.next != null) {
                    if (current.item.compareTo(current.next.item) > 0) {
                        T temp = current.item;
                        current.item = current.next.item;
                        current.next.item = temp;
                        wasChanged = true;
                    }
                    current = current.next;
                }
            } while (wasChanged);
        }
    }

    public int indexOf(Object object) {
        int index = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            if (object.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        int index = size;
        for (Node<T> x = tail; x != null; x = x.prev) {
            index--;
            if (object.equals(x.item)) {
                return index;
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return result;
    }

    public void clear() {
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.next;
            x.item = null;
            x.next = x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    private Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private void remove(Node<T> x) {
        if (x.prev == null) {
            head = x.next;
        } else {
            x.prev.next = x.next;
            x.prev = null;
        }

        if (x.next == null) {
            tail = x.prev;
        } else {
            x.next.prev = x.prev;
            x.next = null;
        }

        x.item = null;
        size--;
    }
}
