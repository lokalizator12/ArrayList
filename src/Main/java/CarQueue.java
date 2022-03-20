public interface CarQueue<T> extends Collection<T>{
    boolean add();

    T peek();

    T poll();
}
