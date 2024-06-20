package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogClient {
    private final String logServiceUrl;
    private final RestTemplate restTemplate;

    public LogClient(@Value("${service.log.url}") String logServiceUrl) {
        this.logServiceUrl = logServiceUrl;
        this.restTemplate = new RestTemplate();
    }

    @Async
    public void log(Object request) {
        restTemplate.postForObject(logServiceUrl + "/log", request, Void.class);
    }
}
