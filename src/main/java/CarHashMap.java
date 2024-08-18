import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap{

    private Entry[] array = new Entry[16];
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    @Override
    public void put(CarOwner key, Car value) {
        if (size >= array.length * LOAD_FACTOR){
            increaseArray();
        }
        boolean put = put(key,value,array);
        if (put){
            size++;
        }
    }

    @Override
    public Car get(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return existedElement.value;
            }
            existedElement = existedElement.next;
        }
        return null;
    }

    @Override
    public Set<CarOwner> keysSet() {
        Set<CarOwner> resultSet = new HashSet<>();
        for (Entry el : array){
            Entry existedElement = el;
            while (existedElement != null){
                resultSet.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return resultSet;
    }

    @Override
    public List<Car> values() {
        List<Car> resultList = new ArrayList<>();
        for (Entry el : array){
            Entry existedElement = el;
            while (existedElement != null){
                resultList.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return resultList;
    }

    @Override
    public boolean remove(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = array[position];

        if (existedElement != null && existedElement.key.equals(key)){
            array[position] = existedElement.next;
            size--;
            return true;
        }else {
            while (existedElement != null){
                Entry nextElement = existedElement.next;
                if (nextElement == null){
                    return false;
                }
                if (nextElement.key.equals(key)){
                    existedElement.next = nextElement.next;
                    size--;
                    return true;
                }
                existedElement = existedElement.next;

            }
        }
        return false;
    }

    private boolean put(CarOwner key, Car value, Entry[] dst){
        int position = getElementPosition(key, dst.length);
        Entry existedEl = dst[position];

        if (existedEl == null) {
            Entry entry = new Entry(key,value,null);
            dst[position] = entry;
            return true;
        }else {
            while (true) {
                if (existedEl.key.equals(key)) {
                    existedEl.value = value;
                    return false;
                }
                if (existedEl.next == null) {
                    existedEl.next = new Entry(key, value, null);
                    return true;
                }
                existedEl = existedEl.next;
            }
        }
    }

    private int getElementPosition(CarOwner carOwner, int arrayLength){
        return Math.abs(carOwner.hashCode() % arrayLength);
    }

    private void increaseArray(){
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry el : array){
            Entry existedElement = el;
            while (existedElement != null){
                put(existedElement.key, existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        array = new Entry[INITIAL_CAPACITY];
    }

    private static class Entry{
        Car value;
        CarOwner key;
        Entry next;

        public Entry(CarOwner key,Car value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
