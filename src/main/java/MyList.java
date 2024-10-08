import java.util.Iterator;

public interface MyList<T> extends MyCollection<T>{

    T get(int index);

    boolean add(T car);
    boolean add(T car, int index);

    boolean remove(T car);
    boolean removeAt(int index);

    int size();

    void clear();

    boolean contains(T car);

    @Override
    Iterator<T> iterator();
}
