package com.example.autobase.services;

import com.example.autobase.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private List<Car> cars = new ArrayList<>();
    private CarAddService carAddService = new CarAddService();
    private CarSearchService carSearchService = new CarSearchService();
    private CarUpdateService carUpdateService = new CarUpdateService();
    private CarDeleteService carDeleteService = new CarDeleteService();

    // Додавання автомобіля
    public void addCar(Car car) {
         carAddService.addCar(car, cars);
    }

    // Пошук автомобіля за ID
    public Car findCarById(String carId) {
        return carSearchService.findCarById(cars, carId);
    }

    // Оновлення автомобіля
    public void updateCar(String carId, Car updatedCar) {
        carUpdateService.updateCar(cars, carId, updatedCar);
    }

    // Видалення автомобіля
    public void deleteCar(String carId) {
        carDeleteService.deleteCar(cars, carId);
    }

    // Список всіх автомобілів
    public List<Car> getCars() {
        return cars;
    }
}
