package com.easycom.requestcounter.service;

import com.easycom.requestcounter.model.RequestCount;
import com.easycom.requestcounter.repository.RequestCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class RequestCountService {

    private final RequestCountRepository repository;

    @Autowired
    public RequestCountService(RequestCountRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            repository.save(new RequestCount(0));
        }
    }

    public int incrementCount() {
        RequestCount requestCount = repository.findAll().get(0);
        requestCount.setCount(requestCount.getCount() + 1);
        repository.save(requestCount);
        return requestCount.getCount();
    }

    public int getCount() {
        return repository.findAll().get(0).getCount();
    }
}
