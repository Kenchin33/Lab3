package com.example.autobase.services;

import com.example.autobase.model.Car;
import com.example.autobase.model.Trip;
import org.springframework.stereotype.Service;

@Service
public class TripCompletionService {

    private CarService carService;

    public TripCompletionService(CarService carService) {
        this.carService = carService;
    }

    // Метод для відмітки рейсу як виконаного і оновлення стану автомобіля
    public String markTripAsCompleted(Trip trip, boolean completed) {
        // Встановлюємо статус виконання рейсу
        trip.setCompleted(completed);

        // Якщо рейс виконано, оновлюємо стан автомобіля
        if (completed) {
            Car car = trip.getCar();
            car.setWorkingCondition(false);  // Змінюємо стан автомобіля на "не в робочому стані"
            carService.updateCar(car.getCarId(), car);  // Оновлюємо автомобіль у системі
        }

        return "Рейс " + (completed ? "виконано" : "не виконано") + " і стан автомобіля оновлено.";
    }
}
