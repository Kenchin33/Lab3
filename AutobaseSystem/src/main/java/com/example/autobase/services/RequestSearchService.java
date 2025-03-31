package com.example.autobase.services;

import com.example.autobase.model.Request;

import java.util.List;

public class RequestSearchService {

    // Пошук заявки за ID
    public Request findRequestById(String requestId, List<Request> requests) {
        for (Request request : requests) {
            if (request.getRequestId().equals(requestId)) {
                return request;
            }
        }
        return null;
    }
}
