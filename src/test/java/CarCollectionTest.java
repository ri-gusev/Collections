import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarCollectionTest {

    private CarCollection collection;
    @Before
    public void setUp() throws Exception {
        collection = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            collection.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void IfOurCollectionContainsOurObjectThenReturnTrue(){
        assertTrue(collection.contains(new Car("Brand10",10)));
        assertFalse(collection.contains(new Car("Brand1990",10)));
    }
}