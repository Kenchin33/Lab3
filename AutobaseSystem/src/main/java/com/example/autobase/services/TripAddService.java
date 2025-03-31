package com.example.autobase.services;

import com.example.autobase.model.Car;
import com.example.autobase.model.Driver;
import com.example.autobase.model.Request;
import com.example.autobase.model.Trip;

import java.util.List;

public class TripAddService {

    public void addTrip(Driver driver, Car car, Request request, List<Trip> trips) {
        if (driver != null && car != null && request != null && car.isWorkingCondition() && car.getType().equals(request.getCarType())) {
            Trip trip = new Trip();
            trip.setTripId("Trip" + trips.size() + 1);
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
