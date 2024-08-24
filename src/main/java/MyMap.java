import java.util.List;
import java.util.Set;

public interface MyMap<T,E> {

    void put(T key, E value);

    E get(T key);

    Set<T> keysSet();

    List<E> values();

    boolean remove(T key);

    int size();

    void clear();
}
