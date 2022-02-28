public class CarHashSet implements CarSet {

    public int size = 0;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Entry[] array = new Entry[INITIAL_CAPACITY];

    @Override
    public boolean add(Car car) {
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
    public boolean contains(Car car) {
        int position = getIndexElement(car, array.length);
        return position < 0;
    }

    public boolean add(Car car, Entry[] dts){
        int position = getIndexElement(car, dts.length);
        if (dts[position] == null) {
            Entry entry = new Entry(car, null);
            dts[position] = entry;
            return true;
        }else{
            Entry sameElement = dts[position];
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
        Entry[] secondArray = new Entry[array.length * 2];
        for (Entry entry : array){
            Entry existedElement = entry;
            while (existedElement != null){
                add(existedElement.value,secondArray);
                existedElement = existedElement.next;
            }
        }
    array = secondArray;
    }

    @Override
    public boolean remove(Car car) {
        int position = getIndexElement(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
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
    array = new Entry[INITIAL_CAPACITY];
    }

    public int getIndexElement(Car car, int arrayLength) {
        if (car == null){
            return -1;
        }
        return Math.abs(car.hashCode() % arrayLength);
    }

    private static class Entry {
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
