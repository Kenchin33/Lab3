package com.example.autobase.controller;

import com.example.autobase.model.Request;
import com.example.autobase.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    // Отримати список всіх заявок
    @GetMapping
    public List<Request> getAllRequests() {
        return requestService.getRequests();
    }

    // Отримати заявку за ID
    @GetMapping("/{requestId}")
    public Request getRequestById(@PathVariable String requestId) {
        return requestService.findRequestById(requestId);
    }

    // Додати нову заявку
    @PostMapping
    public ResponseEntity<String> addRequest(@RequestBody Request request) {
        requestService.addRequest(request);
        return ResponseEntity.ok("Запит додано!");
    }

    // Оновити заявку
    @PatchMapping("/{requestId}")
    public ResponseEntity<String> updateRequest(@PathVariable String requestId, @RequestBody Request updatedRequest) {
        requestService.updateRequest(requestId, updatedRequest);
        return ResponseEntity.ok("Запит оновлено!");
    }


    // Видалити заявку
    @DeleteMapping("/{requestId}")
    public ResponseEntity<String> deleteRequest(@PathVariable String requestId) {
        requestService.deleteRequest(requestId);
        return ResponseEntity.ok("Запит видалено!");
    }
}
