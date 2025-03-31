package com.example.autobase.services;

import com.example.autobase.model.Car;
import com.example.autobase.model.Driver;
import com.example.autobase.model.Request;
import com.example.autobase.model.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    private List<Trip> trips = new ArrayList<>();
    private TripAddService tripAddService = new TripAddService();
    private TripSearchService tripSearchService = new TripSearchService();
    private TripDeleteService tripDeleteService = new TripDeleteService();
    private TripUpdateService tripUpdateService = new TripUpdateService();

    // Додавання рейсу
    public void createTrip(String driverId, String carId, String requestId, DriverService driverService, CarService carService, RequestService requestService) {
        Driver driver = driverService.findDriverById(driverId);
        Car car = carService.findCarById(carId);
        Request request = requestService.findRequestById(requestId);

        tripAddService.addTrip(driver, car, request, trips);
    }

    // Пошук рейсу за ID
    public Trip findTripById(String tripId) {
        return tripSearchService.findTripById(tripId, trips);
    }

    // Видалення рейсу за ID
    public void deleteTrip(String tripId) {
        tripDeleteService.deleteTrip(tripId, trips);
    }

    // Оновлення рейсу
    public void updateTrip(String tripId, Trip newTripData) {
        tripUpdateService.updateTrip(tripId, newTripData, trips);
    }
}
