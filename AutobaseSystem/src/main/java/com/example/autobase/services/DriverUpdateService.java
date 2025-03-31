package com.example.autobase.services;

import com.example.autobase.model.Driver;

import java.util.List;

public class DriverUpdateService {

    // Оновлення даних водія
    public void updateDriver(String driverId, Driver updatedDriver, List<Driver> drivers) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getDriverId().equals(driverId)) {
                drivers.set(i, updatedDriver);
                break;
            }
        }
    }
}
