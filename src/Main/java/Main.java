import java.util.*;


public class Main {
    public static void main(String[] args) {
       Set<Integer> cars = new TreeSet<>(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return -o1.compareTo(o2);
           }
       });
        for (int i = 0; i < 100; i++) {
            cars.add((int) (Math.random() * 10));
        }
        for (Integer car : cars) {
            System.out.println(car);
        }
    }
}
