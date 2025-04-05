package com.example.autobase.controller;

import com.example.autobase.dto.TripCompletionRequest;
import com.example.autobase.dto.TripCreateRequest;
import com.example.autobase.model.Trip;
import com.example.autobase.services.TripService;
import com.example.autobase.services.CarService;
import com.example.autobase.services.DriverService;
import com.example.autobase.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createTrip(@RequestBody TripCreateRequest request) {
        String result = tripService.createTrip(
            request.getDriverId(),
            request.getCarId(),
            request.getRequestId(),
            driverService, carService, requestService
        );
        return ResponseEntity.ok(result);
    }

    // Оновити рейс
    @PatchMapping("/{tripId}")
    public ResponseEntity<String> updateTrip(@PathVariable String tripId, @RequestBody Trip updatedTrip) {
        tripService.updateTrip(tripId, updatedTrip);
        return ResponseEntity.ok("Рейс оновлено!");
    }

    // Видалити рейс
    @DeleteMapping("/{tripId}")
    public ResponseEntity<String> deleteTrip(@PathVariable String tripId) {
        tripService.deleteTrip(tripId);
        return ResponseEntity.ok("Рейс видалено!");
    }

    // Водій ставить відмітку про виконання рейсу і стан автомобіля
    @PatchMapping("/{tripId}/complete")
    public ResponseEntity<String> completeTrip(@PathVariable String tripId, @RequestBody TripCompletionRequest request) {
        boolean success = tripService.completeTrip(tripId, request.isWorkingCondition());
        if (success) {
            return ResponseEntity.ok("Рейс " + tripId + " виконано. Стан автомобіля оновлено.");
        } else {
            return ResponseEntity.badRequest().body("Помилка: Рейс не знайдено!");
        }
    }


}
