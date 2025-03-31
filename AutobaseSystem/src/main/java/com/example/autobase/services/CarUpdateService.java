package com.example.autobase.services;

import com.example.autobase.model.Car;

import java.util.List;

public class CarUpdateService {

    // Оновлення автомобіля
    public void updateCar(List<Car> cars, String carId, Car updatedCar) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCarId().equals(carId)) {
                cars.set(i, updatedCar);
                break;
            }
        }
    }
}
