import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarQueuTest {

    private CarQueu queu;

    @Before
    public void setUp() throws Exception {
        queu = new CarLinkedList();
    }

    @Test
    public void IfAdd10ElementsThenTheSizeMustBe10() {
        for (int i = 0; i < 10; i++) {
            queu.add(new Car("brand" + i));
        }
        assertEquals(10, queu.size());
    }

    @Test
    public void IfPeekThenReturnFirstElement() {
        Car car = new Car("brand0");
        assertTrue(queu.add(car));
        assertEquals(1,queu.size());
        assertEquals("brand0", queu.peek().getBrand());
        assertEquals(1,queu.size());
    }

    @Test
    public void IfPeekInEmptyQueuThenReturnNull() {
        assertNull(queu.peek());
        assertNull(queu.poll());

    }

    @Test
    public void IfPollThenReturnFirstElementAndDeleteIt() {
        Car car = new Car("brand0");
        assertTrue(queu.add(car));
        assertEquals("brand0",queu.poll().getBrand());
        assertEquals(0,queu.size());
    }

}