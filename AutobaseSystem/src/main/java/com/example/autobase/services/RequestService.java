package com.example.autobase.services;

import com.example.autobase.model.Request;

import java.util.List;

public class RequestService {

    private RequestAddService requestAddService = new RequestAddService();
    private RequestSearchService requestFindService = new RequestSearchService();
    private RequestUpdateService requestUpdateService = new RequestUpdateService();
    private RequestDeleteService requestDeleteService = new RequestDeleteService();

    // Додавання заявки
    public void addRequest(Request request, List<Request> requests) {
        requestAddService.addRequest(request, requests);
    }

    // Пошук заявки за ID
    public Request findRequestById(String requestId, List<Request> requests) {
        return requestFindService.findRequestById(requestId, requests);
    }

    // Оновлення заявки
    public void updateRequest(Request updatedRequest, List<Request> requests) {
        requestUpdateService.updateRequest(updatedRequest, requests);
    }

    // Видалення заявки
    public void deleteRequest(String requestId, List<Request> requests) {
        requestDeleteService.deleteRequest(requestId, requests);
    }
}
