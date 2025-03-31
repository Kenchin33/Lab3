package com.example.autobase.services;

import com.example.autobase.model.Car;

import java.util.List;

public class CarSearchService {

    // Пошук автомобіля за ID
    public Car findCarById(List<Car> cars, String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null;
    }
}
