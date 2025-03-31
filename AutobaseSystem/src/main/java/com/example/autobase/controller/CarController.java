package com.example.autobase.controller;

import com.example.autobase.model.Car;
import com.example.autobase.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return ResponseEntity.ok("Автомобіль успішно додано!");
    }

    // Оновити автомобіль
    @PatchMapping("/{carId}")
    public ResponseEntity<String> updateCar(@PathVariable String carId, @RequestBody Car updatedCar) {
        carService.updateCar(carId, updatedCar);
        return ResponseEntity.ok("Автомобіль оновлено!");
    }

    // Видалити автомобіль
    @DeleteMapping("/{carId}")
    public ResponseEntity<String> deleteCar(@PathVariable String carId) {
        carService.deleteCar(carId);
        return ResponseEntity.ok("Автомобіль успішно видалено!");
    }
}
