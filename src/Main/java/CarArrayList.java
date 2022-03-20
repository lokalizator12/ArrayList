import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList<T> implements CarList<T> {

    private Object[] arrayCar = new Object[10];
    private int size = 0;

    @Override
    public boolean contains(T car) {
        for (int i = 0; i < size; i++) {
            if (arrayCar[i].equals(car)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        indexIsCorrect(index);
        return (T) arrayCar[index];
    }

    @Override
    public boolean add(T car) {
        increaseArray();
        arrayCar[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean add(T car, int index) {
        increaseArray();
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(arrayCar, index, arrayCar, index + 1, size - index);
        arrayCar[index] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(T car) {
        for (int i = 0; i < size; i++) {
            if (arrayCar[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        indexIsCorrect(index);
        if(size - index >= 0) {
            System.arraycopy(arrayCar, index, arrayCar, index + 1, size - index);
        }size--;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) arrayCar[index++];
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        arrayCar = new Object[0];

    }

    public void indexIsCorrect(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void increaseArray() {
        if (size >= arrayCar.length) {
            arrayCar = Arrays.copyOf(arrayCar, arrayCar.length * 2);
        }
    }
}
