import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList car1;

    @org.junit.Before
    public void setUp() throws Exception {
        car1 = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            car1.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, car1.size());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased() {
        assertTrue(car1.removeAt(5));
        assertEquals(99, car1.size());
    }

    @Test
    public void whenElementRemoveThenSizeMustBeDecreased() {
        Car newCar = new Car("BMW", 1);
        car1.add(newCar);
        assertEquals(101, car1.size());
        assertTrue(car1.remove(newCar));
        assertEquals(100, car1.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car newCar = new Car("BMW", 15);
        assertFalse(car1.remove(newCar));
        assertEquals(100, car1.size());
    }

    @Test
    public void whenMoveClearResultSizeIs0() {
        car1.clear();
        assertEquals(0, car1.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsExceptionThenThrowException() {
        car1.get(100);
    }

    @Test
    public void whenGettingThenResultIsOut() {
        Car newCar = car1.get(0);
        assertEquals("Brand0", newCar.getBrand());

    }
    @Test
    public void insertIntoMiddle() {
        Car car = new Car("BMW", 1);
        car1.add(car, 50);
        Car carFromList = car1.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("BMW", 1);
        car1.add(car, 0);
        Car carFromList = car1.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("BMW", 1);
        car1.add(car, 100);
        Car carFromList = car1.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }
}