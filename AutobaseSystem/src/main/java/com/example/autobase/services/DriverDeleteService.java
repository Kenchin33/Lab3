package com.example.autobase.services;

import com.example.autobase.model.Driver;

import java.util.List;

public class DriverDeleteService {

    // Видалення водія за ID
    public void deleteDriver(String driverId, List<Driver> drivers) {
        drivers.removeIf(driver -> driver.getDriverId().equals(driverId));
    }
}
