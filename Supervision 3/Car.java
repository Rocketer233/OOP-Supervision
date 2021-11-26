import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
    private String manufacturer;
    private int age;

    Car(String manufacturer, int age){
        this.manufacturer = manufacturer;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
            " manufacturer='" + manufacturer + "'" +
            ", age='" + age + "'" +
            "}";
    }

    public static void main(String[] args) {
        List<Car> list = new ArrayList<>();
        list.add(new Car("Benz", 10));
        list.add(new Car("Benz", 8));
        list.add(new Car("Porsche", 3));
        list.add(new Car("Ford", 4));
        list.add(new Car("Audi", 15));
        Collections.sort(list, new Comparator<Car>() {
            @Override
            public int compare(Car a, Car b){
                int v = a.manufacturer.compareTo(b.manufacturer);
                if(v != 0)
                    return v;
                return Integer.compare(a.age, b.age);
            }
        });
        for(Car car: list)
            System.out.println(car);
    }
}