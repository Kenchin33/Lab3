package com.example.autobase.controller;

import com.example.autobase.model.Driver;
import com.example.autobase.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    // Додати нового водія (тільки `name` і `carId`)
    @PostMapping
    public ResponseEntity<String> addDriver(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String carId = request.get("carId");

        if (name == null || carId == null) {
            return ResponseEntity.badRequest().body("Помилка: Потрібно вказати name і carId.");
        }

        Driver driver = new Driver();
        driver.setName(name);

        boolean success = driverService.addDriver(driver, carId);
        if (success) {
            return ResponseEntity.ok("Водія успішно додано!");
        } else {
            return ResponseEntity.badRequest().body("Помилка: Автомобіль не знайдено. Водія не додано.");
        }
    }

    // Оновити водія
    @PatchMapping("/{driverId}")
    public ResponseEntity<String> updateDriver(@PathVariable String driverId, @RequestBody Driver updatedDriver) {
        driverService.updateDriver(driverId, updatedDriver);
        return ResponseEntity.ok("Водія оновлено!");
    }

    // Видалити водія
    @DeleteMapping("/{driverId}")
    public ResponseEntity<String> deleteDriver(@PathVariable String driverId) {
        driverService.deleteDriver(driverId);
        return ResponseEntity.ok("Водія видалено!");
    }
}
