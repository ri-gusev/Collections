import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> nums = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });

        for (int i = 0; i <= 50; i++) {
            nums.add(i);
        }

        for (Integer num : nums) {
            System.out.println(num);
        }


    }
}
