package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Audi", 1, 2000));
        cars.add(new Car("BMW", 2, 1999));
        cars.add(new Car("Mercedes", 3, 1998));
        cars.add(new Car("Toyota", 4, 1997));
        cars.add(new Car("Nissan", 5, 1996));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getSomeCars(int count) {
        return cars.stream().limit(count).toList();
    }
}
