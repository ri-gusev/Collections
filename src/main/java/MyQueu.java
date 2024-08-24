public interface MyQueu<T> extends MyCollection<T> {

    boolean add(T car);

    T peek();

    T poll();
}
