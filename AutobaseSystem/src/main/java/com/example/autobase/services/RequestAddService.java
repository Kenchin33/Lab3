package com.example.autobase.services;

import com.example.autobase.model.Request;

import java.util.List;

public class RequestAddService {

    // Додавання заявки
    public void addRequest(Request request, List<Request> requests) {
        requests.add(request);
    }
}
