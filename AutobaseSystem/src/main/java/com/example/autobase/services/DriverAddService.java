package com.example.autobase.services;

import com.example.autobase.model.Driver;

import java.util.List;

public class DriverAddService {

    private int driverIdCounter = 1; // Лічильник для генерування ID

    // Додавання водія
    public void addDriver(Driver driver, List<Driver> drivers) {
        // Генерація ID для нового водія
        driver.setDriverId("DRIVER" + driverIdCounter++);
        drivers.add(driver);
        System.out.println("Водій успішно додано!");
    }
}
