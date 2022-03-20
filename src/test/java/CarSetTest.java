import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {
    private CarSet<Car> car1;

    @Before
    public void setUp() throws Exception {
        car1 = new CarHashSet<>();
        for (int i = 0; i < 100; i++) {
            car1.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAddTwoSameAndOneOtherItemsThenResultIsSizeIsThe2() {
        assertEquals(100, car1.size());
        assertTrue(car1.add(new Car("BMW",8)));
        assertFalse(car1.add(new Car("BMW",8)));
        assertEquals(101, car1.size());
    }

    @Test
    public void whenRemoveOneElementThenSizeResultIsMinusOne() {
        assertTrue(car1.add(new Car("BMW", 8)));
        assertFalse(car1.add(new Car("BMW", 8)));
        assertTrue(car1.remove(new Car("BMW", 8)));
        assertEquals(100, car1.size());

    }

    @Test
    public void size() {
        assertTrue(car1.add(new Car("BMW", 8)));
        assertFalse(car1.add(new Car("BMW", 8)));
        assertEquals(101, car1.size());
    }

    @Test
    public void clear() {
        car1.clear();
        assertEquals(0, car1.size());
    }
}