package com.example.autobase.services;

import com.example.autobase.model.Car;

import java.util.List;

public class CarAddService {

    // Додавання автомобіля
    public void addCar(List<Car> cars, Car car) {
        cars.add(car);
    }
}
