package com.example.autobase.services;

import com.example.autobase.model.Driver;
import java.util.List;

public class DriverUpdateService {

    public void updateDriver(String driverId, Driver updatedDriver, List<Driver> drivers) {
        for (Driver driver : drivers) {
            if (driver.getDriverId().equals(driverId)) {
                if (updatedDriver.getName() != null) driver.setName(updatedDriver.getName());
                if (updatedDriver.getCar() != null) driver.setCar(updatedDriver.getCar());
                break;
            }
        }
    }
}
