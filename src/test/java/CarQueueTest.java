import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarQueueTest {

    private CarQueue queue;

    @Before
    public void setUp() throws Exception {
        queue = new CarLinkedList();
        for (int i = 0; i < 10; i++) {
            queue.add(new Car("bmw" + i, i));
        }
    }

    @Test
    public void add() {//add 10 items return 10 size
        assertEquals(10,queue.size());
    }

    @Test
    public void peek() {//choose first item, return 10 size
        assertEquals(10,queue.size());
        Car car = queue.peek();
        assertEquals("bmw0", car.getBrand());
        assertEquals(10,queue.size());
    }

    @Test
    public void poll() {//choose first item and insert then, return 9 size
        assertEquals(10,queue.size());
        Car car = queue.poll();
        assertEquals(9,queue.size());
        assertEquals("bmw0",car.getBrand());

    }
}