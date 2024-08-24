import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHashMap<T,E> implements MyMap<T,E> {

    private Object[] array = new Object[16];
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    @Override
    public void put(T key, E value) {
        if (size >= array.length * LOAD_FACTOR){
            increaseArray();
        }
        boolean put = put(key,value,array);
        if (put){
            size++;
        }
    }

    @Override
    public E get(T key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = (Entry) array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return existedElement.value;
            }
            existedElement = existedElement.next;
        }
        return null;
    }

    @Override
    public Set<T> keysSet() {
        Set<T> resultSet = new HashSet<>();
        for (Object el : array){
            Entry existedElement = (Entry) el;
            while (existedElement != null){
                resultSet.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return resultSet;
    }

    @Override
    public List<E> values() {
        List<E> resultList = new ArrayList<>();
        for (Object el : array){
            Entry existedElement = (Entry) el;
            while (existedElement != null){
                resultList.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return resultList;
    }

    @Override
    public boolean remove(T key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = (Entry) array[position];

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

    private boolean put(T key, E value, Object[] dst){
        int position = getElementPosition(key, dst.length);
        Entry existedEl = (Entry) dst[position];

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

    private int getElementPosition(T carOwner, int arrayLength){
        return Math.abs(carOwner.hashCode() % arrayLength);
    }

    private void increaseArray(){
        Object[] newArray = new Object[array.length * 2];
        for (Object el : array){
            Entry existedElement = (Entry) el;
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
        array = new Object[INITIAL_CAPACITY];
    }

    private class Entry{
        E value;
        T key;
        Entry next;

        public Entry(T key,E value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
