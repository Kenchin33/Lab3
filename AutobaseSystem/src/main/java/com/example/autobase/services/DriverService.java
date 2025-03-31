package com.example.autobase.services;

import com.example.autobase.model.Driver;

import java.util.List;

public class DriverService {

    private DriverAddService driverAddService;
    private DriverSearchService driverSearchService;
    private DriverUpdateService driverUpdateService;
    private DriverDeleteService driverDeleteService;
    private List<Driver> drivers;

    // Конструктор
    public DriverService() {
        this.driverAddService = new DriverAddService();
        this.driverSearchService = new DriverSearchService();
        this.driverUpdateService = new DriverUpdateService();
        this.driverDeleteService = new DriverDeleteService();
    }

    // Додавання водія
    public void addDriver(Driver driver) {
        driverAddService.addDriver(driver, drivers);
    }

    // Пошук водія за ID
    public Driver findDriverById(String driverId) {
        return driverSearchService.findDriverById(driverId, drivers);
    }

    // Оновлення водія
    public void updateDriver(String driverId, Driver updatedDriver) {
        driverUpdateService.updateDriver(driverId, updatedDriver, drivers);
    }

    // Видалення водія
    public void deleteDriver(String driverId) {
        driverDeleteService.deleteDriver(driverId, drivers);
    }

    // Список водіїв
    public List<Driver> getDrivers() {
        return drivers;
    }
}
