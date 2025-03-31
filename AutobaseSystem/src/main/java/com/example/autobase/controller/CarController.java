package com.example.autobase.controller;

import com.example.autobase.model.Car;
import com.example.autobase.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Отримати список всіх автомобілів
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getCars();
    }

    // Отримати автомобіль за ID
    @GetMapping("/{carId}")
    public Car getCarById(@PathVariable String carId) {
        return carService.findCarById(carId);
    }

    // Додати новий автомобіль
    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    // Оновити автомобіль
    @PutMapping("/{carId}")
    public void updateCar(@PathVariable String carId, @RequestBody Car updatedCar) {
        carService.updateCar(carId, updatedCar);
    }

    // Видалити автомобіль
    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable String carId) {
        carService.deleteCar(carId);
    }
}
