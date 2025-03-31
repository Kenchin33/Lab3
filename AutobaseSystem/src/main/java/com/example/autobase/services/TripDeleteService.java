package com.example.autobase.services;

import com.example.autobase.model.Trip;

import java.util.List;

public class TripDeleteService {

    // Видалення рейсу за ID
    public void deleteTrip(String tripId, List<Trip> trips) {
        trips.removeIf(trip -> trip.getTripId().equals(tripId));
        System.out.println("Рейс з ID " + tripId + " був видалений.");
    }
}
