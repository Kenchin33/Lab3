package com.example.autobase.services;

import com.example.autobase.model.Car;
import java.util.List;

public class CarUpdateService {

    public void updateCar(List<Car> cars, String carId, Car updatedCar) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                if (updatedCar.getType() != null) car.setType(updatedCar.getType());
                car.setWorkingCondition(updatedCar.isWorkingCondition());
                break;
            }
        }
    }
}
