package task5;

import task1_4.Car;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1000, Car.CarType.BMW, 2010));
        carList.add(new Car(3000, Car.CarType.AUDI, 2020));
        carList.add(new Car(5000, Car.CarType.DACIA, 2019));

        System.out.println("Initial list");
        carList.forEach(System.out::println);

        carList.removeIf(x -> x.getPrice() > 2000);

        System.out.println("Final list with prices under 2000");
        carList.forEach(System.out::println);
    }
}
