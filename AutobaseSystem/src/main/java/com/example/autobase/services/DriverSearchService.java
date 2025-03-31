package com.example.autobase.services;

import com.example.autobase.model.Driver;

import java.util.List;

public class DriverSearchService {

    // Пошук водія за ID
    public Driver findDriverById(String driverId, List<Driver> drivers) {
        for (Driver driver : drivers) {
            if (driver.getDriverId().equals(driverId)) {
                return driver;
            }
        }
        return null;
    }
}
