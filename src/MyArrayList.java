import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int elementCount = 0;
    private int initialCapacity = 5;

    public MyArrayList() {
        elements = new Object[initialCapacity];
    }

    public T get(int index) {
        return (T) elements[index];
    }

    public void add(T newItem) {
        if (elementCount == initialCapacity) {
            increaseCapacity();
        }
        elements[elementCount++] = newItem;
    }

    private void increaseCapacity() {
        initialCapacity *= 2;
        Object[] newElements = new Object[initialCapacity];
        System.arraycopy(elements, 0, newElements, 0, elementCount);
        elements = newElements;
    }

    public void printArray() {
        for (int i = 0; i < elementCount; i++) {
            System.out.print(elements[i] + " || ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int getSize() {
        return elementCount;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= elementCount) throw new IndexOutOfBoundsException("Invalid index");
        for (int i = index; i < elementCount - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elementCount--;
    }

    @Override
    public void clear() {
        elements = new Object[initialCapacity];
        elementCount = 0;
    }
}
