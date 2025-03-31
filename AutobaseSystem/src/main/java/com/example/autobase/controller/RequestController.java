package com.example.autobase.controller;

import com.example.autobase.model.Request;
import com.example.autobase.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addRequest(@RequestBody Request request) {
        requestService.addRequest(request);
    }

    // Оновити заявку
    @PutMapping("/{requestId}")
    public void updateRequest(@PathVariable String requestId, @RequestBody Request updatedRequest) {
        requestService.updateRequest(updatedRequest);
    }

    // Видалити заявку
    @DeleteMapping("/{requestId}")
    public void deleteRequest(@PathVariable String requestId) {
        requestService.deleteRequest(requestId);
    }
}
