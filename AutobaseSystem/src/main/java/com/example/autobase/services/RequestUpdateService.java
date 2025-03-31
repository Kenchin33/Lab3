package com.example.autobase.services;

import com.example.autobase.model.Request;
import java.util.List;

public class RequestUpdateService {

    public void updateRequest(String requestId, Request updatedRequest, List<Request> requests) {
        for (Request request : requests) {
            if (request.getRequestId().equals(requestId)) {
                if (updatedRequest.getCarType() != null) {
                    request.setCarType(updatedRequest.getCarType());
                }
                break;
            }
        }
    }
}
