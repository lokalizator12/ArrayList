import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapTest {
    private CarOwner person1;
    private CarSet car1;
    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            person1.put(new CarOwner(i,"Piotr"+i,"Lopov"+i),new Car("bmw"+i,i));
        }
    }

    @Test
    public void whenAddPersonWithKeyAndValueCarThenSizePlusOne() {
        assertEquals(person1.size(),100);
        person1.put(new CarOwner(520,"Piotr","Lopov"),new Car("bmw34",520));
        assertEquals(person1.size(),101);

    }

    @Test
    public void get() {
    }

    @Test
    public void keySet() {
    }

    @Test
    public void values() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void size() {
    }

    @Test
    public void clear() {
    }
}