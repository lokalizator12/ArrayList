public interface Collection extends Iterable<Car> {

   boolean add(Car car);
   boolean remove(Car car);
   boolean contains(Car car);
   int size();
   void clear();

}
