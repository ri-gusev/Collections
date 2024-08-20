public interface CarQueu extends CarCollection {

    boolean add(Car car);

    Car peek();

    Car poll();
}
