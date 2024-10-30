package com.easycom.requestcounter.controller;

import com.easycom.requestcounter.service.RequestCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private RequestCountService countService;

    /*@Autowired
    public RequestController(RequestCountService countService) {
        this.countService = countService;
    }*/

    @GetMapping("/count")
    public String handleRequest() {
        int currentCount = countService.incrementCount();
        return "Request count: " + currentCount;
    }
}
