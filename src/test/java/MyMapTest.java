import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyMapTest {

    private MyMap<CarOwner,Car> carMap;

    @Before
    public void setUp() throws Exception {
        carMap = new MyHashMap<CarOwner,Car>();
    }

    @Test
    public void IfPut100ElementsInTheMapThenTheSizeMustBe100(){
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name"+i, "LasName"+i);
            Car value =  new Car("brand"+i,i);
            carMap.put(carOwner,value);
        }
        assertEquals(100,carMap.size());
    }

    @Test
    public void WhenAdd100ElementBut10DiffThenTheSizeMustBe10(){
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "Name" + index, "LastName" + index);
            Car value = new Car("brand"+index,index);
            carMap.put(carOwner,value);
        }
        assertEquals(10,carMap.size());
    }

    @Test
    public void methodGetMustReturnRightValue() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            carMap.put(carOwner, car);
        }
        CarOwner key = new CarOwner(50, "Name50", "LastName50");
        Car value = carMap.get(key);
        String expectedCarBrand = "Brand50";
        assertEquals(expectedCarBrand, value.getBrand());
    }


    @Test
    public void CountOfKeysMustBeEqualsToCountOfValues(){
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "Name"+i, "LasName"+i);
            Car value =  new Car("brand"+i,i);
            carMap.put(carOwner,value);
        }
        assertEquals(10, carMap.size());
        assertEquals(10,carMap.keysSet().size());
        assertEquals(10,carMap.values().size());
    }


    @Test
    public void IfKeyWasRemovedThenTheSizeMustBeDecreasedBy1(){
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "Name"+i, "LastName"+i);
            Car value =  new Car("brand"+i,i);
            carMap.put(carOwner,value);
        }
        assertEquals(10, carMap.size());

        CarOwner owner = new CarOwner(5, "Name5","LastName5");
        assertTrue(carMap.remove(owner));
        assertEquals(9,carMap.size());
        assertFalse(carMap.remove(owner));
    }

    @Test
    public void IfMapClearThenTheSizeMustBe0(){
        carMap.clear();
        assertEquals(0,carMap.size());
    }

}