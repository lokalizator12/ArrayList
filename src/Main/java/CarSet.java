public interface CarSet<T> extends Collection<T>{
    boolean add(T car);
    boolean remove(T car);
    int size();
    void clear();

}
