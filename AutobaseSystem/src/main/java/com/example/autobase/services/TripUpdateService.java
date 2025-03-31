package com.example.autobase.services;

import com.example.autobase.model.Trip;

import java.util.List;

public class TripUpdateService {

    // Оновлення рейсу
    public void updateTrip(String tripId, Trip newTripData, List<Trip> trips) {
        for (int i = 0; i < trips.size(); i++) {
            Trip trip = trips.get(i);
            if (trip.getTripId().equals(tripId)) {
                trips.set(i, newTripData);
                System.out.println("Рейс з ID " + tripId + " був оновлений.");
                return;
            }
        }
        System.out.println("Рейс з ID " + tripId + " не знайдений для оновлення.");
    }
}
