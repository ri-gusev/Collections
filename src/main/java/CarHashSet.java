public class CarHashSet implements CarSet{

    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Entry[] array = new Entry[INITIAL_CAPACITY];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Car car) {
        if (size >= (array.length * LOAD_FACTOR)){
            increaseArray();
        }
        boolean added = add(car, array);
        if (added){
            size++;
        }
        return added;
    }

    private boolean add(Car car, Entry[] dst){
        //element position in array
        int position = getElementPosition(car,dst.length);
        //if there is now element in that position, put this element there
        if(dst[position] == null){
            Entry entry = new Entry(car,null);
            dst[position] = entry;
            return true;
        }else {
            // check if element on that position equals our element (car) -> return false
            Entry existedElement = dst[position];
            while (true) {
                if (existedElement.value.equals(car)) {
                    return false;
                    // if that element does not equal car
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry(car, null);
                    return true;
                } else {
                    existedElement = existedElement.next;
                }
            }
        }
    }


    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null){
            return false;
        }else {
            Entry secondLast = array[position];
            Entry last = secondLast.next;
            if (secondLast.value.equals(car)){
                array[position] = last;
                size--;
                return true;
            }
            while (last != null) {
                if (last.value.equals(car)) {
                    secondLast.next = last.next;
                    size--;
                    return true;
                } else {
                    secondLast = last;
                    last = last.next;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(Car car) {
        int position = getElementPosition(car, array.length);

        Entry existedElement = array[position];
        while (existedElement != null){
            if (existedElement.value.equals(car)){
                return true;
            }else{
                existedElement = existedElement.next;
            }
        }
        return false;
    }

    //Method to find element position
    private int getElementPosition(Car car, int arrayLength){
        return Math.abs(car.hashCode() % arrayLength);
    }

    private void increaseArray(){
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry el : array){
            Entry existedElement = el;
            while (existedElement != null){
                add(existedElement.value,newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }

    private static class Entry{
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }

}
