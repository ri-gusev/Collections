import java.util.Iterator;

public interface CarCollection extends Iterable<Car> {

    int size();

    boolean add(Car car);

    boolean remove(Car car);

    void clear();

    boolean contains(Car car);

    @Override
    Iterator<Car> iterator();
}
