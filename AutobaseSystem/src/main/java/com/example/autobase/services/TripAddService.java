package com.example.autobase.services;

import com.example.autobase.model.Car;
import com.example.autobase.model.Driver;
import com.example.autobase.model.Request;
import com.example.autobase.model.Trip;

import java.util.List;

public class TripAddService {

    private int tripIdCounter = 1; // Лічильник для генерування ID

    // Додавання рейсу
    public void addTrip(Driver driver, Car car, Request request, List<Trip> trips) {
        if (driver != null && car != null && request != null && car.isWorkingCondition() && car.getType().equals(request.getCarType())) {
            Trip trip = new Trip();
            // Генерація ID для нового рейсу
            trip.setTripId("TRIP" + tripIdCounter++);
            trip.setDriver(driver);
            trip.setCar(car);
            trip.setRequest(request);
            trips.add(trip);
            System.out.println("Рейс успішно створено!");
        } else {
            System.out.println("Не вдалося створити рейс: перевірте умови.");
        }
    }
}
