package com.example.autobase.services;

import com.example.autobase.model.Request;

import java.util.List;

public class RequestAddService {

    private int requestIdCounter = 1; // Лічильник для генерування ID

    // Додавання заявки
    public void addRequest(Request request, List<Request> requests) {
        // Генерація ID для нової заявки
        request.setRequestId("REQUEST" + requestIdCounter++);
        requests.add(request);
        System.out.println("Заявка успішно додана!");
    }
}
