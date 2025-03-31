package com.example.autobase.services;

import com.example.autobase.model.Request;

import java.util.List;

public class RequestService {

    private RequestAddService requestAddService = new RequestAddService();
    private RequestSearchService requestFindService = new RequestSearchService();
    private RequestUpdateService requestUpdateService = new RequestUpdateService();
    private RequestDeleteService requestDeleteService = new RequestDeleteService();
    private List<Request> requests;

    // Додавання заявки
    public void addRequest(Request request) {
        requestAddService.addRequest(request, requests);
    }

    // Пошук заявки за ID
    public Request findRequestById(String requestId) {
        return requestFindService.findRequestById(requestId, requests);
    }

    // Оновлення заявки
    public void updateRequest(Request updatedRequest) {
        requestUpdateService.updateRequest(updatedRequest, requests);
    }

    // Видалення заявки
    public void deleteRequest(String requestId) {
        requestDeleteService.deleteRequest(requestId, requests);
    }

    // Список заявок
    public List<Request> getRequests() {
        return requests;
    }
}
