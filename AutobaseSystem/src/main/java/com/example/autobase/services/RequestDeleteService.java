package com.example.autobase.services;

import com.example.autobase.model.Request;

import java.util.List;

public class RequestDeleteService {

    // Видалення заявки
    public void deleteRequest(String requestId, List<Request> requests) {
        requests.removeIf(request -> request.getRequestId().equals(requestId));
    }
}
