import java.util.Iterator;

public interface MySet<T> extends MyCollection<T> {

    int size();

    boolean add(T car);

    boolean remove(T car);

    void clear();

    boolean contains(T car);

    @Override
    Iterator<T> iterator();
}
