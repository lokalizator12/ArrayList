public interface CarQueue extends Collection{
    boolean add();

    Car peek();

    Car poll();
}
