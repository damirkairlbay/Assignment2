import java.util.Iterator;

public interface MyList<T> extends Iterable<T> {
    void add(T item);
    T get(int index);

    void remove(int index);

    void clear();
    int getSize();
    Iterator<T> iterator();
}
