package com.example.autobase.services;

import com.example.autobase.model.Car;
import com.example.autobase.model.Driver;
import com.example.autobase.model.Request;
import com.example.autobase.model.Trip;

import java.util.List;

public class TripAddService {

    private int tripIdCounter = 1; // Лічильник для генерування ID

    // Додавання рейсу
    public String addTrip(Driver driver, Car car, Request request, List<Trip> trips) {
        if (driver != null && car != null && request != null) {
            // Перевірка, чи автомобіль в робочому стані
            if (!car.isWorkingCondition()) {
                return "Не вдалося створити рейс: автомобіль не в робочому стані.";
            }

            // Перевірка, чи тип автомобіля відповідає типу в заявці
            if (!car.getType().equals(request.getCarType())) {
                return "Не вдалося створити рейс: тип автомобіля не відповідає заявці.";
            }

            // Перевірка, чи водій є водієм цього автомобіля
            if (!driver.getCar().getCarId().equals(car.getCarId())) {
                return "Не вдалося створити рейс: водій не є водієм цього автомобіля.";
            }

            // Якщо всі умови виконуються, створюємо рейс
            Trip trip = new Trip();
            // Генерація ID для нового рейсу
            trip.setTripId("TRIP" + tripIdCounter++);
            trip.setDriver(driver);
            trip.setCar(car);
            trip.setRequest(request);
            trips.add(trip);
            System.out.println("Рейс успішно створено!");
            return "Рейс успішно створено!";
        }
        return "Не вдалося створити рейс: перевірте умови.";
    }
}
