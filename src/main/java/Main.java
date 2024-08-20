import java.util.*;

public class Main {
    public static void main(String[] args) {

//        HashMap<CarOwner, Car> map = new HashMap<>();
//
//        CarOwner key = new CarOwner(1, "Roman", "Gusev");
//        Car car = new Car("Toyota", 1);
//        map.put(key,car);
//        key.setId(2);
//
//        System.out.println(map.get(key).getBrand());

        Set<Integer> numbs = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });

        for (int i = 0; i <= 50; i++) {
            numbs.add(i);
        }

        for (Integer num : numbs) {
            System.out.println(num);
        }


    }
}
