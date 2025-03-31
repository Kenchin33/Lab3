package com.example.autobase.services;

import com.example.autobase.model.Driver;

import java.util.List;

public class DriverAddService {

    // Додавання водія
    public void addDriver(Driver driver, List<Driver> drivers) {
        drivers.add(driver);
    }
}
