package com.example.autobase.services;

import com.example.autobase.model.Car;

import java.util.List;

public class CarAddService {

    private int carIdCounter = 1; // Лічильник для генерування ID

    // Додавання автомобіля
    public void addCar(Car car, List<Car> cars) {
        // Генерація ID для нового автомобіля
        car.setCarId("CAR" + carIdCounter++);
        cars.add(car);
        System.out.println("Автомобіль успішно додано!");
    }
}
