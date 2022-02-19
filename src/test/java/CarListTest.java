import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {
    private CarArrayList car1;
    private Car newCar = new Car("audi", 2);

    @org.junit.Before
    public void setUp() throws Exception {
        car1 = new CarArrayList();
        for (int i = 0; i < 100; i++){
            car1.add(new Car("Brand" +i, i));
        }
    }
    @Test
    public void whenAdded100ElementsThenSizeMustBe100(){
        assertEquals(100,car1.size());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased(){
        assertTrue(car1.removeAt(1));
        assertEquals(99,car1.size());
    }

    @Test
    public void whenElementRemoveThenSizeMustBeDecreased(){
    car1.add(newCar);
    assertEquals(101, car1.size());
    assertTrue(car1.remove(newCar));
    assertEquals(100,car1.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse(){
        assertFalse(car1.remove(newCar));
        assertEquals(100,car1.size());
    }

    @Test
    public void whenMoveClearResultSizeIs0(){
        car1.clear();
        assertEquals(0,car1.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsExceptionThenThrowException(){
        car1.get(100);
    }

    @Test
    public void whenGettingThenResultIsOut(){
        newCar = car1.get(0);
        assertEquals("Brand0", newCar.getBrand());

    }
}