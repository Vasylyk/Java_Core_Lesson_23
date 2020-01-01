package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMV",150);
        Car car2 = new Car("Mercedes",140);
        Car car3 = new Car("Porsche",200);
        Car car4 = new Car("Ferrari",250);
        Car car5 = new Car("Ford",120);

        Collection<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        System.out.println("Before sorting:");
        System.out.println(cars.toString());

        List<Car> sortedCars = cars.stream().sorted().collect(Collectors.toList());
        System.out.println("After sorting:");
        System.out.println(sortedCars.toString());
    }
}
