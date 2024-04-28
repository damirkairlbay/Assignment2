import java.util.NoSuchElementException;
public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
