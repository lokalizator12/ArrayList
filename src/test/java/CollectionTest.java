import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollectionTest {

    private Collection CarCollection;

    @Before
    public void setUp() throws Exception {
        CarCollection = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            CarCollection.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void contains() {
        assertTrue(CarCollection.contains(new Car("Brand20", 20)));
        assertFalse(CarCollection.contains(new Car("Brand2000",900)));
    }


}