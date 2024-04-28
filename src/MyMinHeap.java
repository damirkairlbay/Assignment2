import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public void add(T item) {
        heap.add(item);
        int i = heap.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            T currentItem = heap.get(i);
            T parentItem = heap.get(parent);
            if (currentItem.compareTo(parentItem) >= 0) {
                break;
            }
            heap.add(parent, currentItem);
            heap.add(i, parentItem);
            i = parent;
        }
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T minItem = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.add(0, lastItem);
            minHeapify(0);
        }
        return minItem;
    }


    private void minHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            T temp = heap.get(i);
            heap.add(i, heap.get(smallest));
            heap.add(smallest, temp);
            minHeapify(smallest);
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }
}
