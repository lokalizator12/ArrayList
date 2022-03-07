import java.util.*;


public class Main {
    public static void main(String[] args) {
        Collection cars = new CarArrayList();
        for (int i = 0; i <= 10; i++) {
            cars.add(new Car("Brand" + i, i));
        }
        for (Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getNumber());
        }
    }
}
