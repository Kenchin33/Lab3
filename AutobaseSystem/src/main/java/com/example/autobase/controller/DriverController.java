package com.example.autobase.controller;

import com.example.autobase.model.Driver;
import com.example.autobase.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // Отримати список всіх водіїв
    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getDrivers();
    }

    // Отримати водія за ID
    @GetMapping("/{driverId}")
    public Driver getDriverById(@PathVariable String driverId) {
        return driverService.findDriverById(driverId);
    }

    // Додати нового водія
    @PostMapping
    public void addDriver(@RequestBody Driver driver) {
        driverService.addDriver(driver);
    }

    // Оновити водія
    @PutMapping("/{driverId}")
    public void updateDriver(@PathVariable String driverId, @RequestBody Driver updatedDriver) {
        driverService.updateDriver(driverId, updatedDriver);
    }

    // Видалити водія
    @DeleteMapping("/{driverId}")
    public void deleteDriver(@PathVariable String driverId) {
        driverService.deleteDriver(driverId);
    }
}
