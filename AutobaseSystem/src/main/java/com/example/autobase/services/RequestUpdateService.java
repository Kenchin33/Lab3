package com.example.autobase.services;

import com.example.autobase.model.Request;

import java.util.List;

public class RequestUpdateService {

    // Оновлення заявки
    public void updateRequest(Request updatedRequest, List<Request> requests) {
        for (int i = 0; i < requests.size(); i++) {
            if (requests.get(i).getRequestId().equals(updatedRequest.getRequestId())) {
                requests.set(i, updatedRequest);
                break;
            }
        }
    }
}
