package com.example.autobase.services;

import com.example.autobase.model.Trip;

import java.util.List;

public class TripSearchService {

    // Пошук рейсу за ID
    public Trip findTripById(String tripId, List<Trip> trips) {
        for (Trip trip : trips) {
            if (trip.getTripId().equals(tripId)) {
                return trip;
            }
        }
        return null;
    }
}
