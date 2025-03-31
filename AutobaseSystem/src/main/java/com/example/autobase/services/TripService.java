package com.example.autobase.services;

import com.example.autobase.model.Car;
import com.example.autobase.model.Driver;
import com.example.autobase.model.Request;
import com.example.autobase.model.Trip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    private List<Trip> trips = new ArrayList<>();
    private TripAddService tripAddService = new TripAddService();
    private TripSearchService tripSearchService = new TripSearchService();
    private TripDeleteService tripDeleteService = new TripDeleteService();
    private TripUpdateService tripUpdateService = new TripUpdateService();
    private final TripCompletionService tripCompletionService;
    private final RequestService requestService;

    public TripService(TripCompletionService tripCompletionService, RequestService requestService) {
        this.tripCompletionService = tripCompletionService;
        this.requestService = requestService;
    }

    // Додавання рейсу
    public String createTrip(String driverId, String carId, String requestId, DriverService driverService, CarService carService, RequestService requestService) {
        Driver driver = driverService.findDriverById(driverId);
        Car car = carService.findCarById(carId);
        Request request = requestService.findRequestById(requestId);

        if (driver == null || car == null || request == null) {
            return "Помилка: Неможливо створити рейс, оскільки водій, авто або заявка не знайдені!";
        }

        return tripAddService.addTrip(driver, car, request, trips);
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

    // Отримати всі рейси
    public List<Trip> getTrips() {
        return trips;
    }

    // Відмітка про виконання рейсу та оновлення стану автомобіля
    public boolean completeTrip(String tripId, boolean workingCondition) {
        Trip trip = findTripById(tripId);
        if (trip == null) {
            return false;
        }

        // Викликаємо сервіс завершення рейсу
        tripCompletionService.markTripAsCompleted(trip, workingCondition);

        // Автоматично видаляємо відповідний запит
        requestService.deleteRequest(trip.getRequest().getRequestId());

        return true;
    }
}
