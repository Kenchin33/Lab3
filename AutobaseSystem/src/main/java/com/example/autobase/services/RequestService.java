package com.example.autobase.services;

import com.example.autobase.model.Request;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private RequestAddService requestAddService = new RequestAddService();
    private RequestSearchService requestFindService = new RequestSearchService();
    private RequestUpdateService requestUpdateService = new RequestUpdateService();
    private RequestDeleteService requestDeleteService = new RequestDeleteService();
    private List<Request> requests = new ArrayList<>();

    // Додавання заявки
    public void addRequest(Request request) {
        requestAddService.addRequest(request, requests);
    }

    // Пошук заявки за ID
    public Request findRequestById(String requestId) {
        return requestFindService.findRequestById(requestId, requests);
    }

    // Оновлення заявки
    public void updateRequest(String requestId, Request updatedRequest) {
        requestUpdateService.updateRequest(requestId, updatedRequest, requests);
    }

    // Видалення заявки
    public void deleteRequest(String requestId) {
        requestDeleteService.deleteRequest(requestId, requests);
    }

    // Список всіх заявок
    public List<Request> getRequests() {
        return requests;
    }
}
