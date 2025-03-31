package com.example.autobase.services;

import com.example.autobase.model.Car;

import java.util.List;

public class CarDeleteService {

    // Видалення автомобіля
    public void deleteCar(List<Car> cars, String carId) {
        cars.removeIf(car -> car.getCarId().equals(carId));
    }
}
