package com.example.autobase.services;

import com.example.autobase.model.Trip;
import java.util.List;

public class TripUpdateService {

    public void updateTrip(String tripId, Trip updatedTrip, List<Trip> trips) {
        for (Trip trip : trips) {
            if (trip.getTripId().equals(tripId)) {
                if (updatedTrip.getDriver() != null) trip.setDriver(updatedTrip.getDriver());
                if (updatedTrip.getCar() != null) trip.setCar(updatedTrip.getCar());
                if (updatedTrip.getRequest() != null) trip.setRequest(updatedTrip.getRequest());
                trip.setCompleted(updatedTrip.isCompleted());
                break;
            }
        }
    }
}
