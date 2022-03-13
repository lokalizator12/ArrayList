import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapTest {
    private CarMap person1;

    @Before
    public void setUp() throws Exception {
        person1 = new CarHashMap();
    }

    @Test
    public void whenAddPersonWithKeyAndValueCarThenSizePlusOne() {
        for (int i = 0; i < 100; i++) {
            person1.put(new CarOwner(i, "Piotr" + i, "Lopov" + i), new Car("bmw" + i, i));
        }
        assertEquals(person1.size(), 100);
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSize10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "name" + index, "surname" + index);
            Car car = new Car("bmw" + index, index);
            person1.put(carOwner, car);
        }
        assertEquals(10, person1.size());
    }

    @Test
    public void removeReturnTrueOnlyOnce() {
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "name" + i, "surname" + i);
            Car car = new Car("bmw" + i, i);
            person1.put(carOwner, car);
        }
        assertEquals(10, person1.size());
        CarOwner keyForDelete = new CarOwner(3, "name3", "surname3");
        assertTrue(person1.remove(keyForDelete));
        assertEquals(9, person1.size());
        assertFalse(person1.remove(keyForDelete));
    }

    @Test
    public void whenAdd10PersonThenReturn10NameAnd10Id() {
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "name" + i, "surname" + i);
            Car car = new Car("bmw" + i, i);
            person1.put(carOwner, car);
        }
        assertEquals(10, person1.size());
        assertEquals(10, person1.keySet().size());
        assertEquals(10, person1.values().size());
    }


    @Test
    public void whenGetKeyThenReturnHerStringName() {
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "name" + i, "surname" + i);
            Car car = new Car("name" + i, i);
            person1.put(carOwner, car);
        }
        CarOwner keyForGet = new CarOwner(4, "name4", "surname4");
        Car value = person1.get(keyForGet);
        assertEquals("name4", value.getBrand());
    }
}