import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap<K,T> implements CarMap<K,T> {

    private static final int INITIAL_CAPACITY = 16;
    public static final double LOAD_FACTOR = 0.75;
    private Object[] array = new Object[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, T value) {
        if (size >= array.length * LOAD_FACTOR) {
            increaseArray();
        }
        boolean put = put(key, value, array);
        if (put) {
            size++;
        }
    }

    private boolean put(K key, T value, Object[] newA) {
        int position = getPosition(key, newA.length);
        Entry existedElement = (Entry) newA[position];
        if (existedElement == null) {
            Entry entry = new Entry(key, value, null);
            newA[position] = entry;
            return true;
        } else {
            while (true) {
                if (existedElement.key.equals(key)) {
                    existedElement.value = value;
                    return false;
                }
                if (existedElement.next == null) {
                    existedElement.next = new Entry(key, value, null);
                    return true;
                }
                existedElement = existedElement.next;
            }
        }
    }

    @Override
    public T get(K key) {
        int position = getPosition(key, array.length);
        Entry existedElement = (Entry) array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return (T) existedElement.value;
            }
            existedElement = existedElement.next;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (Object entry : array) {
            Entry existedElement = (Entry ) entry;
            while (existedElement != null) {
                result.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    public void increaseArray() {
        Object[] newArray = new Object[array.length * 2];
        for (Object entry : array) {
            Entry existedElement =(Entry) entry;
            while (existedElement != null) {
                put(existedElement.key, existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }

    @Override
    public List<T> values() {
        List<T> result = new ArrayList<>();
        for (Object entry : array) {
            Entry existedElement = (Entry) entry;
            while (existedElement != null) {
                result.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return result;

    }

    private int getPosition(K carOwner, int hashMapLength) {
        return Math.abs(carOwner.hashCode() % hashMapLength);
    }

    @Override
    public boolean remove(K key) {
        int position = getPosition(key, array.length);
        Entry existedElement = (Entry) array[position];
        if (existedElement != null && existedElement.key.equals(key)) {
            array[position] = existedElement.next;
            size--;
            return true;
        } else {
            while (existedElement != null) {
                Entry nextElement = existedElement.next;
                if (nextElement == null) {
                    return false;
                }
                if (nextElement.key.equals(key)) {
                    existedElement.next = nextElement.next;
                    size--;
                    return true;
                }
                existedElement = existedElement.next;
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
        array = new Object[INITIAL_CAPACITY];
        size = 0;

    }

    private class Entry {
        private K key;
        private T value;
        private Entry next;

        public Entry(K key, T value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
