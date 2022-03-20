import java.util.Iterator;

public class CarHashSet<T> implements CarSet<T> {

    public int size = 0;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Object[] array = new Object[INITIAL_CAPACITY];

    @Override
    public boolean add(T car) {
        if (size >= (array.length * LOAD_FACTOR)){
            increaseArray();
        }
        boolean result = add(car, array);
        if (result){
            size++;
        }
    return result;
    }

    @Override
    public boolean contains(T car) {
        int position = getIndexElement(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = (Entry) array[position];
        Entry last = secondLast.next;
        if(secondLast.value.equals(car)){
            return true;
        }
        while (last != null){
            if(last.value.equals(car)){
                return true;
            }else{
                last = last.next;
            }
        }
        return false;
    }

    public boolean add(T car, Object[] dts){
        int position = getIndexElement(car, dts.length);
        if (dts[position] == null) {
            Entry entry = new Entry(car, null);
            dts[position] = entry;
            return true;
        }else{
            Entry sameElement = (Entry) dts[position];
            while (true){
                if (sameElement.value.equals(car)){
                    return false;
                }else if(sameElement.next == null){
                    sameElement.next = new Entry(car,null);
                    return true;
                }else{
                    sameElement = sameElement.next;
                }
            }
        }
    }

    private void increaseArray(){
        Object[] secondArray = new Object[array.length * 2];
        for (Object entry : array){
            Entry existedElement = ( Entry) entry;
            while (existedElement != null){
                add(existedElement.value,secondArray);
                existedElement = existedElement.next;
            }
        }
    array = secondArray;
    }

    @Override
    public boolean remove(T car) {
        int position = getIndexElement(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = (Entry) array[position];
        Entry last = secondLast.next;
        if(secondLast.value.equals(car)){
            array[position] = last;
            size--;
            return true;
        }
       while (last != null){
           if(last.value.equals(car)){
               secondLast.next = last.next;
               size--;
               return true;
           }else{
               secondLast = last;
               last = last.next;
           }
       }
       return false;
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Entry entry;
            int indexArray = 0;
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                while (array[indexArray] == null){
                    indexArray++;
                }
                if (entry == null){
                    entry = (Entry) array[indexArray];
                }
                T result = (T) entry.value;
                entry = entry.next;
                if(entry == null){
                    indexArray++;
                }
                index++;
                return result;
            }
        };
    }

    public int getIndexElement(T car, int arrayLength) {
        if (car == null){
            return -1;
        }
        return Math.abs(car.hashCode() % arrayLength);
    }

    private class Entry {
        private T value;
        private Entry next;

        public Entry(T value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
