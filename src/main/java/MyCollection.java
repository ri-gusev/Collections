import java.util.Iterator;

public interface MyCollection<T> extends Iterable<T> {

    int size();

    boolean add(T car);

    boolean remove(T car);

    void clear();

    boolean contains(T car);

    @Override
    Iterator<T> iterator();
}
