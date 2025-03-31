package com.example.autobase.controller;

import com.example.autobase.model.Trip;
import com.example.autobase.services.TripService;
import com.example.autobase.services.CarService;
import com.example.autobase.services.DriverService;
import com.example.autobase.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripService tripService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private CarService carService;
    @Autowired
    private RequestService requestService;

    // Отримати список всіх рейсів
    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getTrips();
    }

    // Отримати рейс за ID
    @GetMapping("/{tripId}")
    public Trip getTripById(@PathVariable String tripId) {
        return tripService.findTripById(tripId);
    }

    // Створити новий рейс
    @PostMapping
    public void createTrip(@RequestParam String driverId, @RequestParam String carId, @RequestParam String requestId) {
        tripService.createTrip(driverId, carId, requestId, driverService, carService, requestService);
    }

    // Оновити рейс
    @PutMapping("/{tripId}")
    public void updateTrip(@PathVariable String tripId, @RequestBody Trip updatedTrip) {
        tripService.updateTrip(tripId, updatedTrip);
    }

    // Видалити рейс
    @DeleteMapping("/{tripId}")
    public void deleteTrip(@PathVariable String tripId) {
        tripService.deleteTrip(tripId);
    }
}
