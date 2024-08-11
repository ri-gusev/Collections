import java.util.Objects;

public class Car {

    private String brand;
    private int number;

    Car(){}

    Car(String brand, int number){
        this.brand = brand;
        this.number = number;
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number == car.number && Objects.equals(brand, car.brand);
    }

    public Car returnCar(){
        return(this);
    }
    @Override
    public int hashCode() {
        return Objects.hash(brand, number);
    }

}
