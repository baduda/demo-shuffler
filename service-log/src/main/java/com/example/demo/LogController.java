package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @PostMapping("/log")
    public void logRequest(@RequestBody Object request) {
        System.out.println("Received request: " + request);
    }
}
