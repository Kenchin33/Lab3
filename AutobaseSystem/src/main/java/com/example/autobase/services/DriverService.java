package com.example.autobase.services;

import com.example.autobase.model.Car;
import com.example.autobase.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    private DriverAddService driverAddService;
    private DriverSearchService driverSearchService;
    private DriverUpdateService driverUpdateService;
    private DriverDeleteService driverDeleteService;
    private List<Driver> drivers = new ArrayList<>();

    @Autowired
    private CarService carService; // Додаємо залежність для пошуку машин

    public DriverService() {
        this.driverAddService = new DriverAddService();
        this.driverSearchService = new DriverSearchService();
        this.driverUpdateService = new DriverUpdateService();
        this.driverDeleteService = new DriverDeleteService();
    }

    // Додавання водія з автоматичним підвантаженням даних про машину
    public boolean addDriver(Driver driver, String carId) {
        Car existingCar = carService.findCarById(carId);
        if (existingCar == null) {
            System.out.println("Помилка: Автомобіль з ID " + carId + " не знайдено.");
            return false; // Не додаємо водія, якщо автомобіля немає
        }
        
        // Призначаємо водієві знайдений автомобіль
        driver.setCar(existingCar);
        driverAddService.addDriver(driver, drivers);
        return true;
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
