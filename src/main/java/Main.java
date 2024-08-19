import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Set<Integer> numbs = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -o1.compareTo(o2);
//            }
//        });
//
//        for (int i = 0; i <= 50; i++) {
//            numbs.add(i);
//        }
//
//        for (Integer num : numbs) {
//            System.out.println(num);
//        }
        Map<Integer,String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, "Name"+ i);
        }

        for (Integer y : map.keySet()){
            System.out.println(y);
        }

        System.out.println(map);

        System.out.println(map.remove(1));


    }
}
