import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySetTest {

    private MySet carset;

    @Before
    public void setUp() throws Exception{
        carset = new MyHashSet();
        for (int i = 0; i < 100; i++) {
            carset.add(new Car("brand"+ i, i));
        }
    }

    @Test
    public void WhenAdd3SimilarObjectsThenSizeIncreaseBy1(){
        assertEquals(100,carset.size());
        assertTrue(carset.add(new Car("Bmw",1)));
        assertFalse(carset.add(new Car("Bmw",1)));
        assertFalse(carset.add(new Car("Bmw",1)));
        assertEquals(101,carset.size());
    }


    @Test
    public void WhenRemoveElementThatIsInSetThenReturnTrue(){
        assertEquals(100,carset.size());
        assertTrue(carset.remove(new Car("brand0",0)));
        assertEquals(99,carset.size());
        assertFalse(carset.remove(new Car("brand0",0)));
        assertEquals(99,carset.size());
    }

    @Test
    public void WhenClearSetTheSizeMustBe0(){
        carset.clear();
        assertEquals(0,carset.size());
    }

}