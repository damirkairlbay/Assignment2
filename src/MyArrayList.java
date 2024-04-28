import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements = new Object[10];
    private int size = 0;

    public void add(T item) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = item;
    }

    public void add(int index, T item) {
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    public void addFirst(T item) {
        add(0, item);
    }

    public void addLast(T item) {
        add(item);
    }

    public T get(int index) {
        return (T) elements[index];
    }

    public T getFirst() {
        return (T) elements[0];
    }

    public T getLast() {
        return (T) elements[size - 1];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T oldValue = (T) elements[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index+1, elements, index, numMoved);
        }
        elements[--size] = null; // clear to let GC do its work

        return oldValue;
    }


    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (((T) elements[i]).compareTo((T) elements[j]) > 0) {
                    T temp = (T) elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                if (!hasNext()) {
                    throw new RuntimeException("No such element");
                }
                return (T) elements[index++];
            }
        };
    }
}
